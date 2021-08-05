package com.csandovalm.springcajeroapp.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.csandovalm.springcajeroapp.api.request.Cliente;
import com.csandovalm.springcajeroapp.api.service.ApiService;
import com.csandovalm.springcajeroapp.model.Cajero;
import com.csandovalm.springcajeroapp.model.ColaTicket;
import com.csandovalm.springcajeroapp.websocket.service.SocketService;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
@RestController
@RequestMapping("/api")
public class ApiController {

	@Autowired
	private ApiService apiService;

	@Autowired
	SocketService socketService;

	int contador = 0;

	@PostMapping(path = "/generar-ticket", produces = "application/json")
	public ResponseEntity<ColaTicket> generateTicket(@RequestBody Cliente cliente) {


		ColaTicket cola = apiService.GenerarTicket(cliente.getNombre());

		if (cola != null)
			return new ResponseEntity<ColaTicket>(cola, HttpStatus.OK);
		else
			return new ResponseEntity<ColaTicket>(HttpStatus.BAD_REQUEST);
	}

	@GetMapping(path = "/listar-cajeros", produces = "application/json")
	public ResponseEntity<List<Cajero>> listarCajeros() {
		List<Cajero> listaCajeros = apiService.ListaCajeros();

		if (listaCajeros != null)
			return new ResponseEntity<List<Cajero>>(listaCajeros, HttpStatus.OK);
		else
			return new ResponseEntity<List<Cajero>>(HttpStatus.BAD_REQUEST);
	}

	@GetMapping(path = "/actualizar-exclusivo/{id}", produces = "application/json")
	public ResponseEntity<List<Cajero>> actualizarExclusivo(@PathVariable("id") Integer id) {
		boolean operacion = apiService.ActualizarExclusivo(id);

		if (operacion)
			return new ResponseEntity<List<Cajero>>(HttpStatus.OK);
		else
			return new ResponseEntity<List<Cajero>>(HttpStatus.BAD_REQUEST);
	}

	@GetMapping(path = "/actualizar-normal/{id}", produces = "application/json")
	public ResponseEntity<List<Cajero>> actualizarNormal(@PathVariable("id") Integer id) {
		boolean operacion = apiService.ActualizarNormal(id);

		if (operacion)
			return new ResponseEntity<List<Cajero>>(HttpStatus.OK);
		else
			return new ResponseEntity<List<Cajero>>(HttpStatus.BAD_REQUEST);
	}

	@GetMapping(path = "/actualizar-preferencial/{id}", produces = "application/json")
	public ResponseEntity<List<Cajero>> actualizarPreferencial(@PathVariable("id") Integer id) {
		boolean operacion = apiService.ActualizarPreferencial(id);

		if (operacion)
			return new ResponseEntity<List<Cajero>>(HttpStatus.OK);
		else
			return new ResponseEntity<List<Cajero>>(HttpStatus.BAD_REQUEST);
	}

	@GetMapping(path = "/test-cajeros", produces = "application/json")
	public ResponseEntity<String> TestAsignacion() {
		socketService.AsignarCajeroTicket();

		return new ResponseEntity<String>("Funcionando", HttpStatus.OK);
	}

	@GetMapping(path = "/test-fin-ticket", produces = "application/json")
	public ResponseEntity<String> TestFinTicket() {
		socketService.checkTicketsFinalizados();

		return new ResponseEntity<String>("Funcionando Fin Ticket", HttpStatus.OK);
	}
}