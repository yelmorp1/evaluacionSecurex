package com.csandovalm.springcajeroapp.websocket.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import com.csandovalm.springcajeroapp.websocket.service.SocketService;



@EnableScheduling
@Controller
public class SocketController {

	private static final Logger logger = LoggerFactory.getLogger(SocketService.class);

	@Autowired
	SocketService socketService;

	@Autowired
	private SimpMessagingTemplate template;




	@Scheduled(fixedRate = 5000)
	public void bit() {
		this.template.convertAndSend("/cajeros-app-out/bit", "Bit");
	}

	@Scheduled(fixedRate = 10000)
	public void AsignarCajeroTicket() {
		try {
			logger.info("AsignarCajeroTicket Inicio");
			socketService.AsignarCajeroTicket();
			logger.info("AsignarCajeroTicket Fin");
		} catch (Exception e) {
			logger.info("AsignarCajeroTicket Error", e);
		}
	}

	@Scheduled(fixedRate = 5000)
	public void checkTicketsFinalizados() {
		try {
			logger.info("checkTicketsFinalizados Inicio");
			socketService.checkTicketsFinalizados();
			logger.info("checkTicketsFinalizados Fin");
		} catch (Exception e) {
			logger.info("checkTicketsFinalizados Error", e);
		}
	}
}
