package com.house.digital.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.house.digital.dto.CaracteristicaDto;
import com.house.digital.entity.Caracteristica;
import com.house.digital.service.CaracteristicaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "Servicio REST de características", description = "Gestión de los servicios de características")
@RestController
@RequestMapping("/api/carateristica")
public class CaracteristicaController {
	
	@Autowired
	private CaracteristicaService caracteristicaService;
	
	@ApiOperation(value = "Obtener lista de características", produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = HttpServletResponse.SC_OK, message = "Retorna lista de características")})
	@GetMapping("/obtenerCaracteristicas")
	public ResponseEntity<List<CaracteristicaDto>> obtenerCaracteristicas() {
		
		return new ResponseEntity<>(caracteristicaService.obtenerCaracteristica(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Crear características", produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = HttpServletResponse.SC_CREATED, message = "Retorna característica")})
	@PostMapping("/crearCaracteristica")
	public ResponseEntity<CaracteristicaDto> crearCaracteristica(
			@ApiParam(name = "Caracteristica", type = "Object", value = "Atributos para crear característica", required = true)
			@RequestBody Caracteristica caracteristica) {
		
		return new ResponseEntity<>(caracteristicaService.crearCaracteristica(caracteristica), HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Obtener característica", produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = HttpServletResponse.SC_OK, message = "Retorna característica")})
	@GetMapping("/obtenerCaracteristicaPorId/{id}")
	public ResponseEntity<CaracteristicaDto> obtenerCaracteristicaPorId(
			@ApiParam(name = "id", example = "1", type = "Integer", value = "Id de la característica", required = true)
			@PathVariable Long id){
		
		return new ResponseEntity<>(caracteristicaService.obtenerCaracteristicaPorId(id), HttpStatus.OK);
	}

}
