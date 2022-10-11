package com.house.digital.security;

import static com.house.digital.security.SecurityConstants.APPLICATION_JSON_VALUE;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class HandlerAuthenticationEntryPoint implements AuthenticationEntryPoint{

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		
		final Map<String, Object> mapAuthenticationEntryPoint = new HashMap<>();
		
		authException.printStackTrace();
		
		LocalDateTime currentDateTime = LocalDateTime.now();
		final DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

		mapAuthenticationEntryPoint.put("timestamp", currentDateTime.format(formatter));
		mapAuthenticationEntryPoint.put("status", String.valueOf(UNAUTHORIZED.value()));
		mapAuthenticationEntryPoint.put("error", UNAUTHORIZED.getReasonPhrase());
		mapAuthenticationEntryPoint.put("message", "Usuario no autorizado para acceder a este recurso");
		mapAuthenticationEntryPoint.put("path", request.getServletPath());
		
		Set<Map<String, Object>> errorAux = new HashSet<>();
		errorAux.add(mapAuthenticationEntryPoint);
		
		response.setContentType(APPLICATION_JSON_VALUE);
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

		new ObjectMapper().writeValue(response.getOutputStream(), errorAux);
	
	}

}