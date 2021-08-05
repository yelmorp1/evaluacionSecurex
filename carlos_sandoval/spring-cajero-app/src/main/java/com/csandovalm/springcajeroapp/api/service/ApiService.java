package com.csandovalm.springcajeroapp.api.service;

import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.csandovalm.springcajeroapp.api.repo.ICajeroRepo;
import com.csandovalm.springcajeroapp.api.repo.IColaTicketRepo;
import com.csandovalm.springcajeroapp.model.Cajero;
import com.csandovalm.springcajeroapp.model.ColaTicket;

@Service
public class ApiService {

	private static final Logger logger = LoggerFactory.getLogger(ApiService.class);

	@Autowired
	private IColaTicketRepo colaTicketRepo;
	@Autowired
	private ICajeroRepo cajeroRepo;

	public ColaTicket GenerarTicket(String nombre) {
		try {
			ColaTicket cola = new ColaTicket();
			cola.setNombreCliente(nombre);
			cola.setEdad(edadRandom());
			cola.setEstado(1);
			return colaTicketRepo.save(cola);
		} catch (Exception e) {
			logger.info("Error { }", e);
			return null;
		}
	}

	public List<Cajero> ListaCajeros() {
		try {
			List<Cajero> listaCajeros = cajeroRepo.findAll(Sort.by(Sort.Direction.ASC, "idCajero"));
			return listaCajeros;
		} catch (Exception e) {
			logger.info("Error { }", e);
			return null;
		}
	}

	public boolean ActualizarExclusivo(int idCajero) {
		try {
			Cajero cajero = cajeroRepo.getById(idCajero);
			cajero.setExclusivo(!cajero.getExclusivo());
			cajeroRepo.save(cajero);
			return true;
		} catch (Exception e) {
			logger.info("Error { }", e);
			return false;
		}
	}

	public boolean ActualizarNormal(int idCajero) {
		try {
			Cajero cajero = cajeroRepo.getById(idCajero);
			cajero.setNormal(!cajero.getNormal());
			cajeroRepo.save(cajero);
			return true;
		} catch (Exception e) {
			logger.info("Error { }", e);
			return false;
		}
	}

	public boolean ActualizarPreferencial(int idCajero) {
		try {
			logger.info("ActualizarPreferencial");
			Cajero cajero = cajeroRepo.getById(idCajero);
			cajero.setPreferencial(!cajero.getPreferencial());
			cajeroRepo.save(cajero);
			return true;
		} catch (Exception e) {
			logger.info("Error { }", e);
			return false;
		}
	}

	private int edadRandom() {
		Random rng = new Random();
		int min = 18;
		int max = 70;
		int upperBound = max - min + 1;
		int num = min + rng.nextInt(upperBound);
		return num;
	}
}
