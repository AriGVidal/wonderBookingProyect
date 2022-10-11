package com.house.digital.service;

import java.util.List;

import com.house.digital.dto.UsuarioDto;
import com.house.digital.entity.Usuario;

public interface UsuarioService {
	
	UsuarioDto crearUsuario(UsuarioDto usuarioDto);
	
	UsuarioDto obtenerUsuarioById(Long id);
	
	List<UsuarioDto> obtenerUsuarios();
	
	UsuarioDto actualizarUsuario(UsuarioDto usuarioDto);
	
	void eliminarUsuario(Long id);

	Usuario getByUserName(String userName);

}
