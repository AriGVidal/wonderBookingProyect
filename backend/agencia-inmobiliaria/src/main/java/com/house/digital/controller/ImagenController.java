package com.house.digital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.house.digital.entity.Imagen;
import com.house.digital.service.ImagenService;

import io.swagger.annotations.Api;

@Api(value = "Servicio REST de imágenes", description = "Gestión de los servicios de imágenes")
@RestController
@RequestMapping("/api/imagen")
public class ImagenController {
	
	@Autowired
	private ImagenService imagenService;
	
	@PostMapping("/crearImagen")
	public ResponseEntity<?> crearImagen(@RequestBody Imagen imagen) {
		return new ResponseEntity<>(imagenService.crearImagen(imagen), HttpStatus.CREATED);
	}
	
	@GetMapping("/obtenerImagenPorId/{id}")
	public ResponseEntity<?> obtenerImagenPorId(@PathVariable Long id){
		return new ResponseEntity<>(imagenService.obtenerImagenPorId(id), HttpStatus.OK);
	}

}
