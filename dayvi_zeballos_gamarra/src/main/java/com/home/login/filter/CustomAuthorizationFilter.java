package com.home.login.filter;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomAuthorizationFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		if (request.getServletPath().equals("/api/login") || request.getServletPath().equals("/api/token/refresh") ) { // Se ignora para el login
			filterChain.doFilter(request, response);
		} else { // Se valida el token
			String authorizationHeader = request.getHeader(AUTHORIZATION);
			if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
				try {
					String token = authorizationHeader.substring("Bearer ".length());
					Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
					JWTVerifier verifier = JWT.require(algorithm).build();
					DecodedJWT decodedJWT = verifier.verify(token);
					String username = decodedJWT.getSubject();
					String[] roles = decodedJWT.getClaim("roles").asArray(String.class);
					Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
					for (String rol : roles) {
						authorities.add(new SimpleGrantedAuthority(rol));
					}

					UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
							username, null, authorities);
					SecurityContextHolder.getContext().setAuthentication(authenticationToken);

					request.setAttribute("jwt", username); // para auditoria devuelve el username

					filterChain.doFilter(request, response);
					
				}catch (TokenExpiredException ex) { 

					response.setHeader("error_expired", "refreshToken");
					response.setStatus(FORBIDDEN.value());
					Map<String, String> errors = new HashMap<>();
					errors.put("error_expired", "refreshToken");
					response.setContentType("application/json");
					new ObjectMapper().writeValue(response.getOutputStream(), errors);
				
				}catch (Exception exception) {

					log.error("Error al loguearse: ", exception);
					response.setHeader("error", exception.getMessage());
					response.setStatus(FORBIDDEN.value());
					Map<String, String> errors = new HashMap<>();
					errors.put("error_message", exception.getMessage());
					response.setContentType("application/json");
					new ObjectMapper().writeValue(response.getOutputStream(), errors);
				}

			} else {
				filterChain.doFilter(request, response);
			}
		}

	}

}
