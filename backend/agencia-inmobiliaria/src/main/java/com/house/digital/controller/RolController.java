package com.house.digital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.house.digital.dto.RolDto;
import com.house.digital.service.RolService;

import io.swagger.annotations.Api;

@Api(value = "Servicio REST de roles", description = "Gestión de los servicios de roles")
@RestController
@RequestMapping("/api/rol")
public class RolController {

	@Autowired
	private RolService rolService;

	@PostMapping("/crearRol")
	public ResponseEntity<RolDto> crearRol(@RequestBody RolDto rolDto) {
		return new ResponseEntity<>(rolService.crearRol(rolDto), HttpStatus.CREATED);
	}

	@GetMapping("/obtenerRolPorId/{id}")
	public ResponseEntity<RolDto> obtenerRolPorId(@PathVariable Long id) {
		return new ResponseEntity<>(rolService.obtenerRolById(id), HttpStatus.OK);
	}

	@GetMapping("/obtenerRoles")
	public ResponseEntity<List<RolDto>> obtenerRoles() {
		return new ResponseEntity<>(rolService.obtenerRoles(), HttpStatus.OK);
	}

	@PutMapping("/actualizarRol")
	public ResponseEntity<RolDto> actualizarRol(@RequestBody RolDto rolDto) {
		return new ResponseEntity<>(rolService.actualizarRol(rolDto), HttpStatus.OK);
	}

	@DeleteMapping("/eliminarRol/{id}")
	public ResponseEntity<String> eliminarRol(@PathVariable Long id) {
		rolService.eliminarRol(id);
		return new ResponseEntity<>("", HttpStatus.NO_CONTENT);
	}

}
