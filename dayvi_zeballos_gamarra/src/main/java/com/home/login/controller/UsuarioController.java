package com.home.login.controller;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.home.login.model.TblRole;
import com.home.login.model.TblUsuario;
import com.home.login.request.ReqRole;
import com.home.login.request.ReqRoleToUsuario;
import com.home.login.request.ReqUsuario;
import com.home.login.service.UsuarioService;

@RestController
@RequestMapping("/api")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/usuarios")
	public ResponseEntity<List<TblUsuario>> listar(){
		return ResponseEntity.ok(usuarioService.getUsers());
	}
	
	@PostMapping("/usuario")
	public ResponseEntity<TblUsuario> guardarUsuario(@RequestBody ReqUsuario request){
		return ResponseEntity.ok(usuarioService.saveUsuario(request));
	}
	
	@PostMapping("/role")
	public ResponseEntity<TblRole> guardarRol(@RequestBody ReqRole request){
		return ResponseEntity.ok(usuarioService.saveRol(request));
	}
	
	@PostMapping("/usuario/agregarrol")
	public ResponseEntity<?> agregarRol(@RequestBody ReqRoleToUsuario request){
		usuarioService.addRoleToUsuario(request.getUserName(), request.getNameRol());
		return ResponseEntity.ok().body("OK");
	}
	
	@GetMapping("/token/refresh")
	public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String authorizationHeader = request.getHeader(AUTHORIZATION);
		
		if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
			try {
				String refresh_token = authorizationHeader.substring("Bearer ".length());
				Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
				JWTVerifier verifier = JWT.require(algorithm).build();
				DecodedJWT decodedJWT = verifier.verify(refresh_token);
				String username = decodedJWT.getSubject();
				TblUsuario user = usuarioService.getUser(username);
				
				String acces_token = JWT.create().withSubject(user.getUsername())
						.withExpiresAt(new Date(System.currentTimeMillis() + 3 * 60 * 1000))
						.withIssuer(request.getRequestURL().toString())
						.withClaim("roles",	user.getRoles().stream().map(TblRole::getName).collect(Collectors.toList()))
						.sign(algorithm);

				
				response.setHeader("acces_token", acces_token);
				response.setHeader("refresh_token", refresh_token);
				
				Map<String, String> tokens = new HashMap<>();
				tokens.put("acces_token", acces_token);
				
				response.setContentType("application/json");
				new ObjectMapper().writeValue(response.getOutputStream(), tokens);
			

			}catch (Exception exception) {
				
				response.setHeader("error", exception.getMessage());
				response.setStatus(FORBIDDEN.value());
				Map<String, String> errors = new HashMap<>();
				errors.put("error_message", exception.getMessage());
				response.setContentType(MimeTypeUtils.APPLICATION_JSON_VALUE);
				new ObjectMapper().writeValue(response.getOutputStream(), errors);
			}

		} else {
			throw new RuntimeException("No se encuentra refresh token");
		}
		
	}
	
	
	
}
