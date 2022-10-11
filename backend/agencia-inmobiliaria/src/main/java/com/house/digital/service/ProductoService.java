package com.house.digital.service;

import com.house.digital.dto.ProductoDTO;
import com.house.digital.dto.ProductoPostDto;

import java.util.List;

public interface ProductoService {
	
	ProductoDTO actualizarProducto(ProductoPostDto productoPostDto);

    ProductoDTO crearProducto(ProductoPostDto productoPostDto);

    ProductoDTO obtenerProductoPorId(Long id);

    List<ProductoDTO> obtenerProductosPorCiudadId(Long ciudadId, String checkIn, String checkOut);

    List<ProductoDTO> obtenerProductosPorCategoriaId(Long categoriaId);

    List<ProductoDTO> obtenerProductos(String checkIn, String checkOut);

    void eliminarProducto(Long id);

}
