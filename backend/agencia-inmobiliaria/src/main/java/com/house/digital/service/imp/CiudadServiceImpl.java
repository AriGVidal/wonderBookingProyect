package com.house.digital.service.imp;


import com.house.digital.dto.CiudadDto;
import com.house.digital.entity.Ciudad;
import com.house.digital.exception.ResourceNotFoundException;
import com.house.digital.mapper.CiudadMapper;
import com.house.digital.repository.CiudadRepository;
import com.house.digital.service.CiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CiudadServiceImpl implements CiudadService {

    private final CiudadMapper ciudadMapper;
    private final CiudadRepository ciudadRepository;

    @Autowired
    public CiudadServiceImpl(CiudadMapper ciudadMapper, CiudadRepository ciudadRepository) {
        this.ciudadMapper = ciudadMapper;
        this.ciudadRepository = ciudadRepository;
    }

    @Override
    public CiudadDto crearCiudad(CiudadDto ciudadDto) {
        Ciudad ciudad = ciudadMapper.ciudadDtoToCiudad(ciudadDto);
        ciudadRepository.save(ciudad);
        return ciudadMapper.ciudadToCiudadDto(ciudad);
    }

    @Override
    public List<CiudadDto> listarCiudades() {
        List<Ciudad> ciudadList = ciudadRepository.findAll();

        if (!ciudadList.isEmpty()) {
            return ciudadMapper.listCiudadToListCiudadDto(ciudadList);
        } else {
            throw new ResourceNotFoundException("No se encontraron ciudades");
        }
    }

    @Override
    public CiudadDto obtenerCiudadPorId(Long id) {
        Ciudad ciudad = ciudadRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No se encontraó ninguna ciudad con el id: " + id));

        return ciudadMapper.ciudadToCiudadDto(ciudad);
    }
}

