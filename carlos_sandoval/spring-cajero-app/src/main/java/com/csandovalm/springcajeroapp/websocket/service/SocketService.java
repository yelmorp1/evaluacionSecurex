package com.csandovalm.springcajeroapp.websocket.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.csandovalm.springcajeroapp.api.repo.ICajeroRepo;
import com.csandovalm.springcajeroapp.api.repo.IColaTicketRepo;
import com.csandovalm.springcajeroapp.api.service.ApiService;
import com.csandovalm.springcajeroapp.model.Cajero;
import com.csandovalm.springcajeroapp.model.ColaTicket;

@Service
public class SocketService {

	private static final Logger logger = LoggerFactory.getLogger(SocketService.class);

	@Autowired
	private IColaTicketRepo colaTicketRepo;
	@Autowired
	private ICajeroRepo cajeroRepo;
	@Autowired
	private ApiService apiService;
	@Autowired
	private SimpMessagingTemplate template;

	public void AsignarCajeroTicket() {
		try {
			boolean notificar = false;
			List<ColaTicket> listaColaTicketEspera = colaTicketRepo.findAllByEnEspera();
			for (ColaTicket colaTicket : listaColaTicketEspera) {
				if ((colaTicket.getEdad() % 3 == 0) && colaTicket.getEdad() < 60) {
					// intenta colocar a un cliente en un cajero exclusivo
					List<Cajero> listaCajero = cajeroRepo.findAllCajerosExclusivosActivos();
					notificar = asignarCajero(colaTicket, listaCajero);
				} else if (colaTicket.getEdad() > 60) {
					// intenta colocar a un cliente en un cajero Preferencial, de lo contrario lo
					// manda a uno normal
					List<Cajero> listaCajero = cajeroRepo.findAllCajerosPreferencialesActivos();
					if (listaCajero.size() != 0) {
						notificar = asignarCajero(colaTicket, listaCajero);
					} else {
						List<Cajero> listaCajeroAux = cajeroRepo.findAllCajerosNormalesActivos();
						notificar = asignarCajero(colaTicket, listaCajeroAux);
					}
				} else {
					// intenta colocar a un cliente en un cajero normal
					List<Cajero> listaCajero = cajeroRepo.findAllCajerosNormalesActivos();
					notificar = asignarCajero(colaTicket, listaCajero);
				}
			}

			if (notificar == true)
				notificarMonitor();

		} catch (Exception e) {
			logger.info("Error { }", e);
		}
	}

	public boolean asignarCajero(ColaTicket colaTicket, List<Cajero> listaCajero) {
		boolean notificar = false;

		Cajero cajeroSeleccionado = null;
		Random rand = new Random();
		if (listaCajero.size() > 0) {
			cajeroSeleccionado = listaCajero.get(rand.nextInt(listaCajero.size()));
			LocalDateTime fechaActual = LocalDateTime.now();
			cajeroSeleccionado.setEstado(true);
			cajeroSeleccionado.setTicket(colaTicket.getIdColaTicket());
			cajeroSeleccionado.setCliente(colaTicket.getNombreCliente());
			colaTicket.setEstado(2);
			colaTicket.setFechaInicio(fechaActual);
			colaTicket.setFechaFin(fechaActual.plusSeconds(15));
			colaTicketRepo.save(colaTicket);
			cajeroRepo.save(cajeroSeleccionado);
			notificar = true;
		}

		return notificar;
	}

	public void checkTicketsFinalizados() {
		List<ColaTicket> listaColaTicketAtendiendo = colaTicketRepo.findAllByAtendiendo();

		LocalDateTime fechaActual = LocalDateTime.now();

		boolean notificar = false;

		for (ColaTicket colaTicket : listaColaTicketAtendiendo) {
			if (fechaActual.isEqual(colaTicket.getFechaFin()) || fechaActual.isAfter(colaTicket.getFechaFin())) {
				colaTicket.setEstado(3);
				colaTicketRepo.save(colaTicket);
				Cajero cajeroAux = cajeroRepo.findCajeroByTicket(colaTicket.getIdColaTicket());
				cajeroAux.setTicket(null);
				cajeroAux.setCliente(null);
				cajeroAux.setEstado(false);
				cajeroRepo.save(cajeroAux);
				notificar = true;
			}
		}

		if (notificar == true)
			notificarMonitor();
	}

	private void notificarMonitor() {
		List<Cajero> listaCajeros = apiService.ListaCajeros();
		this.template.convertAndSend("/cajeros-app-out/socket-listar-cajeros", listaCajeros);
	}

}
