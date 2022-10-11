package com.house.digital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.house.digital.dto.CategoriaDto;
import com.house.digital.service.CategoriaService;

import io.swagger.annotations.Api;

@Api(value = "Servicio REST de categorías", description = "Gestión de los servicios de categorías")
@RestController
@RequestMapping("/api/categoria")
@CrossOrigin
public class CategoriaController {

	private CategoriaService categoriaService;

	@Autowired
	public CategoriaController (CategoriaService categoriaService){
		this.categoriaService = categoriaService;
	}
	
	@PostMapping("/crear")
	public ResponseEntity<CategoriaDto> crearCategoria(@RequestBody CategoriaDto categoriaDto) {		
		return new ResponseEntity<>(categoriaService.crearCategoria(categoriaDto), HttpStatus.CREATED);
	}

	@GetMapping("/obtenerCategorias")
	public ResponseEntity<List<CategoriaDto>> obtenerCategorias() {
		return new ResponseEntity<>(categoriaService.obtenerCategorias(), HttpStatus.OK);
	}
	
	@GetMapping("/obtenerCategoriaPorId/{id}")
	public ResponseEntity<CategoriaDto> obtenerCategoriaPorId(@PathVariable Long id) {
		return new ResponseEntity<>(categoriaService.obtenerCategoriaPorId(id), HttpStatus.OK);
	}

	@PutMapping("/actualizarCategoria")
	public ResponseEntity<CategoriaDto> actualizarCategoria(@RequestBody CategoriaDto categoriaDto)  {
		return new ResponseEntity<>(categoriaService.actualizarCategoria(categoriaDto), HttpStatus.OK);
	}

	@DeleteMapping("/eliminarCategoria/{id}")
	public ResponseEntity<String> eliminarCategoria(@PathVariable("id") Long id)  {
		categoriaService.eliminarCategoria(id);
		return new ResponseEntity<>("Categoria eliminada", HttpStatus.NO_CONTENT);
	}	

}
