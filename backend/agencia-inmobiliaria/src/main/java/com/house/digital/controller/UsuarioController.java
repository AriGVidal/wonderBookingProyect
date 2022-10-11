package com.house.digital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.house.digital.dto.UsuarioDto;
import com.house.digital.service.UsuarioService;

import io.swagger.annotations.Api;

@Api(value = "Servicio REST de usuarios", description = "Gestión de los servicios de usuarios")
@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;

	@PostMapping("/crearUsuario")
	public ResponseEntity<UsuarioDto> crearUsuario(@RequestBody UsuarioDto usuarioDto) {
		return new ResponseEntity<>(usuarioService.crearUsuario(usuarioDto), HttpStatus.CREATED);
	}

	@GetMapping("/obtenerUsuarioPorId/{id}")
	//@PreAuthorize("hasAnyRole('ROLE_ADMINISTRADOR')")
	public ResponseEntity<UsuarioDto> obtenerUsuarioPorId(@PathVariable Long id) {
		return new ResponseEntity<>(usuarioService.obtenerUsuarioById(id), HttpStatus.OK);
	}

	@GetMapping("/obtenerUsuarios")
	//@PreAuthorize("hasAnyRole('ROLE_ADMINISTRADOR')")
	public ResponseEntity<List<UsuarioDto>> obtenerUsuarios() {
		return new ResponseEntity<>(usuarioService.obtenerUsuarios(), HttpStatus.OK);
	}

	@PutMapping("/actualizarUsuario")
	//@PreAuthorize("hasAnyRole('ROLE_ADMINISTRADOR')")
	public ResponseEntity<UsuarioDto> actualizarUsuario(@RequestBody UsuarioDto usuarioDto) {
		return new ResponseEntity<>(usuarioService.actualizarUsuario(usuarioDto), HttpStatus.OK);
	}

	@DeleteMapping("/eliminarUsuario/{id}")
	//@PreAuthorize("hasAnyRole('ROLE_ADMINISTRADOR')")
	public ResponseEntity<String> eliminarUsuario(@PathVariable Long id) {
		usuarioService.eliminarUsuario(id);
		return new ResponseEntity<>("", HttpStatus.NO_CONTENT);
	}

}
