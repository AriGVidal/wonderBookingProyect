package com.house.digital.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.house.digital.dto.CategoriaDto;
import com.house.digital.entity.Categoria;
import com.house.digital.exception.ResourceNotFoundException;
import com.house.digital.mapper.CategoriaMapper;
import com.house.digital.repository.CategoriaRepository;
import com.house.digital.service.CategoriaService;

@Service
public class CategoriaServiceImp implements CategoriaService{

	private CategoriaMapper categoriaMapper;
	private CategoriaRepository categoriaRepository;

	@Autowired
	public CategoriaServiceImp(CategoriaRepository categoriaRepository, CategoriaMapper categoriaMapper) {
		this.categoriaRepository = categoriaRepository;
		this.categoriaMapper = categoriaMapper;
	}

	@Override
	public CategoriaDto crearCategoria(CategoriaDto categoriaDto) {
		
		Categoria categoria = categoriaMapper.categoriaDtoToCategoria(categoriaDto);
		
		categoriaRepository.save(categoria);
		
		return categoriaMapper.categoriaToCategoriaDto(categoria);
	}
	
	@Override
	public CategoriaDto obtenerCategoriaPorId(Long id) {
		
		Categoria categoria = categoriaRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("No se encontraron categorias con el id: " + id));
		
		return categoriaMapper.categoriaToCategoriaDto(categoria);
		
	}

	@Override
	public List<CategoriaDto> obtenerCategorias() {
		
		List<Categoria> listaCategorias = categoriaRepository.findAll();
		
		if(!listaCategorias.isEmpty()) {
			return categoriaMapper.listaCategoriaToListaCategoriaDto(listaCategorias);
		}
		else {
			throw new ResourceNotFoundException("No hay categorias encontradas");
		}
	}

	@Override
	public CategoriaDto actualizarCategoria(CategoriaDto categoriaDto) {
		
			if(categoriaRepository.existsById(categoriaDto.getId())){
				
				Categoria categoria = categoriaMapper.categoriaDtoToCategoria(categoriaDto);
				
				categoriaRepository.save(categoria);
				
				return categoriaMapper.categoriaToCategoriaDto(categoria);
				
			} else {
				throw new ResourceNotFoundException("No se encontraron categorias con el id: " + categoriaDto.getId());
			}
		}


	@Override
	public void eliminarCategoria(Long id) {
		
		Categoria categoria = categoriaRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("No se encontraron categorias con el id: " + id));
		
		categoriaRepository.delete(categoria);
	}


}
