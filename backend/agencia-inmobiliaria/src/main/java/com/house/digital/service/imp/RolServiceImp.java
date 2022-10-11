package com.house.digital.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.house.digital.dto.RolDto;
import com.house.digital.entity.Rol;
import com.house.digital.exception.ResourceNotFoundException;
import com.house.digital.mapper.RolMapper;
import com.house.digital.repository.RolRepository;
import com.house.digital.service.RolService;

@Service
public class RolServiceImp implements RolService {

	@Autowired
	private RolRepository rolRepository;

	private static final String MESSAGE = "No se encontraron roles con el id: ";

	@Override
	public RolDto crearRol(RolDto rolDto) {

		Rol rol = RolMapper.INSTANCE.rolDtoToRol(rolDto);
		rolRepository.save(rol);
		return RolMapper.INSTANCE.roleToRoleDto(rol);

	}

	@Override
	public RolDto obtenerRolById(Long id) {

		Rol rol = rolRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(MESSAGE + id));

		return RolMapper.INSTANCE.roleToRoleDto(rol);
	}

	@Override
	public List<RolDto> obtenerRoles() {

		List<Rol> listRol = rolRepository.findAll();

		if (!listRol.isEmpty()) {
			return RolMapper.INSTANCE.listRolToListRolDto(listRol);
		} else {
			throw new ResourceNotFoundException("No hay roles registrados");
		}
	}

	@Override
	public RolDto actualizarRol(RolDto rolDto) {

		if (rolRepository.existsById(rolDto.getId())) {
			Rol rol = RolMapper.INSTANCE.rolDtoToRol(rolDto);
			rolRepository.save(rol);
			return RolMapper.INSTANCE.roleToRoleDto(rol);
		} else {
			throw new ResourceNotFoundException("No hay roles registrados");
		}

	}

	@Override
	public void eliminarRol(Long id) {

		Rol rol = rolRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(MESSAGE + id));

		rolRepository.delete(rol);

	}

}
