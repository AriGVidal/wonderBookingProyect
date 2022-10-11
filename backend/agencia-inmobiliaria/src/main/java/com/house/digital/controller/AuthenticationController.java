package com.house.digital.controller;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.house.digital.dto.LoginRequestDto;
import com.house.digital.security.TokenService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "Servicio REST de autenticación", description = "Gestión de los servicios de autenticación")
@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private TokenService tokenService;
		
	@ApiOperation(value = "Retornar credenciales de acceso al usuario", produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = HttpServletResponse.SC_OK, message = "Retorna credenciales de acceso"),
			@ApiResponse(code = HttpServletResponse.SC_UNAUTHORIZED, message = "La contraseña del usuario no es correcta"),
			@ApiResponse(code = HttpServletResponse.SC_NOT_FOUND, message = "El correo del usuario no existe") })
	@PostMapping("/login")
	public ResponseEntity<Map<String, String>> login(
			@ApiParam(name = "LoginRequestDto", type = "Object", value = "Atributos para la autenticación", required = true)
			@RequestBody LoginRequestDto loginDto) {
		
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		Map<String, String> informationToken = tokenService.createToken(authentication);
		
		return new ResponseEntity<>(informationToken, HttpStatus.OK);
	}
	

}