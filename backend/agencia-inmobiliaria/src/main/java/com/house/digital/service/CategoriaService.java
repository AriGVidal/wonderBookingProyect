package com.house.digital.service;

import java.util.List;

import com.house.digital.dto.CategoriaDto;

public interface CategoriaService {

	CategoriaDto crearCategoria(CategoriaDto categoriaDto);
	
	CategoriaDto obtenerCategoriaPorId(Long id);

	List<CategoriaDto> obtenerCategorias();
	
	CategoriaDto actualizarCategoria(CategoriaDto categoriaDto);
	
	void eliminarCategoria(Long id);

}
