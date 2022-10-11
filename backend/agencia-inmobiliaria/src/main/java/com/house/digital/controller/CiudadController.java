package com.house.digital.controller;

import com.house.digital.dto.CiudadDto;
import com.house.digital.service.CiudadService;

import io.swagger.annotations.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Servicio REST de ciudades", description = "Gestión de los servicios de ciudades")
@RestController
@RequestMapping("/api/ciudades")
@CrossOrigin
public class CiudadController {

    private final CiudadService ciudadService;

    @Autowired
    public CiudadController (CiudadService ciudadService) {
        this.ciudadService = ciudadService;
    }

    @PostMapping("/crearCiudad")
    public ResponseEntity<CiudadDto> crearCiudad(@RequestBody CiudadDto ciudadDto) {
        return new ResponseEntity<>(ciudadService.crearCiudad(ciudadDto), HttpStatus.CREATED);
    }

    @GetMapping("/listarCiudades")
    public ResponseEntity<List<CiudadDto>> listarCiudades() {
        return new ResponseEntity<>(ciudadService.listarCiudades(), HttpStatus.OK);
    }

    @GetMapping("/obtenerCiudadPorId/{id}")
    public ResponseEntity<CiudadDto> obtenerCiudadPorId(@PathVariable Long id) {
        return new ResponseEntity<>(ciudadService.obtenerCiudadPorId(id), HttpStatus.OK);
    }
}

