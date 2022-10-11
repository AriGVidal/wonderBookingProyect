package com.house.digital.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.house.digital.dto.UsuarioDto;
import com.house.digital.entity.Usuario;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
	
	UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);
	
	Usuario usuarioDtoToUsuario(UsuarioDto usuarioDto);
	
	@Mapping(target = "password", ignore = true)
	UsuarioDto usuarioToUsuarioDto(Usuario usuario);
	
	List<UsuarioDto> listUsuarioToListUsuarioDto(List<Usuario> listUsuario);

}
