package com.house.digital.controller;

import com.house.digital.dto.ProductoDTO;
import com.house.digital.dto.ProductoPostDto;
import com.house.digital.service.ProductoService;

import io.swagger.annotations.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Servicio REST de productos", description = "Gestión de los servicios de productos")
@RestController
@RequestMapping("/api/producto")
@CrossOrigin
public class ProductoController {

    private ProductoService productoService;

    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }
    
    @PutMapping("/actualizarProducto")
    public ResponseEntity<ProductoDTO> actualizarProducto(@RequestBody ProductoPostDto productoPostDto) {
        return new ResponseEntity<>(productoService.actualizarProducto(productoPostDto), HttpStatus.OK);
    }
    
    @PostMapping("/crear")
    public ResponseEntity<ProductoDTO> crearProducto(@RequestBody ProductoPostDto productoPostDto) {
        return new ResponseEntity<>(productoService.crearProducto(productoPostDto), HttpStatus.CREATED);
    }

    @GetMapping("/obtenerProductos")
    public ResponseEntity<List<ProductoDTO>> obtenerProductos(
            @RequestParam(name = "check_in", required = false) String checkIn,
            @RequestParam(name = "check_out", required = false) String checkOut) {
        return new ResponseEntity<>(productoService.obtenerProductos(checkIn, checkOut), HttpStatus.OK);
    }

    @GetMapping("/obtenerProductosCiudad/{id}")
    public ResponseEntity<List<ProductoDTO>> obtenerProductosPorCiudad(@PathVariable Long id,
                                                                       @RequestParam(name = "check_in", required = false) String checkIn,
                                                                       @RequestParam(name = "check_out", required = false) String checkOut) {
        return new ResponseEntity<>(productoService.obtenerProductosPorCiudadId(id, checkIn, checkOut), HttpStatus.OK);
    }

    @GetMapping("/obtenerProductosCategoria/{id}")
    public ResponseEntity<List<ProductoDTO>> obtenerProductosPorCategoria(@PathVariable Long id) {
        return new ResponseEntity<>(productoService.obtenerProductosPorCategoriaId(id), HttpStatus.OK);
    }

    @GetMapping("/obtenerProductoPorId/{id}")
    public ResponseEntity<ProductoDTO> obtenerProductoPorId(@PathVariable Long id) {
        return new ResponseEntity<>(productoService.obtenerProductoPorId(id), HttpStatus.OK);
    }

    @DeleteMapping("/eliminarProducto/{id}")
    public ResponseEntity<String> eliminarProducto(@PathVariable("id") Long id)  {
        productoService.eliminarProducto(id);
        return new ResponseEntity<>("Producto eliminado", HttpStatus.NO_CONTENT);
    }
}
