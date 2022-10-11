package com.house.digital.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.house.digital.dto.RolDto;
import com.house.digital.entity.Rol;

@Mapper(componentModel = "spring")
public interface RolMapper {
	
	RolMapper INSTANCE = Mappers.getMapper(RolMapper.class);
	
	Rol rolDtoToRol(RolDto rol);
	
	RolDto roleToRoleDto(Rol rol);
	
	List<RolDto> listRolToListRolDto(List<Rol> listRol);

}
