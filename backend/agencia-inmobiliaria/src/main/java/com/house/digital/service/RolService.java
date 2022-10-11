package com.house.digital.service;

import java.util.List;

import com.house.digital.dto.RolDto;

public interface RolService {
	
	RolDto crearRol(RolDto rolDto);
	
	RolDto obtenerRolById(Long id);
	
	List<RolDto> obtenerRoles();
	
	RolDto actualizarRol(RolDto rolDto);
	
	void eliminarRol(Long id);

}
