package com.house.digital.controller;

import com.house.digital.dto.PoliticaDTO;
import com.house.digital.dto.PoliticaGroupResponseDTO;
import com.house.digital.service.PoliticaService;

import io.swagger.annotations.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "Servicio REST de políticas", description = "Gestión de los servicios de políticas")
@RestController
@RequestMapping("/api/politica")
@CrossOrigin
public class PoliticaController {
    private final PoliticaService politicaService;

    @Autowired
    public PoliticaController (PoliticaService politicaService) {
        this.politicaService = politicaService;
    }

    @GetMapping("/obtenerPoliticasPorProducto/{id}")
    public ResponseEntity<List<PoliticaGroupResponseDTO>> obtenerPoliticaPorProducto(@PathVariable Long id) {
        return new ResponseEntity<>(this.politicaService.listaPoliticasPorProducto(id), HttpStatus.OK);
    }

    @GetMapping("/obtenerPoliticasPorProducto2/{id}")
    public ResponseEntity<List<PoliticaDTO>> politicasPorProducto(@PathVariable Long id) {
        return new ResponseEntity<>(this.politicaService.getPoliticas(id), HttpStatus.OK);
    }

}

