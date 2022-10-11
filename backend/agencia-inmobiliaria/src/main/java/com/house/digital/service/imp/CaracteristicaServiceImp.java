package com.house.digital.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.house.digital.dto.CaracteristicaDto;
import com.house.digital.entity.Caracteristica;
import com.house.digital.exception.ResourceNotFoundException;
import com.house.digital.mapper.CaracteristicaMapper;
import com.house.digital.repository.CaracteristicaRepository;
import com.house.digital.service.CaracteristicaService;

@Service
public class CaracteristicaServiceImp implements CaracteristicaService {
    private CaracteristicaMapper caracteristicaMapper;
    private CaracteristicaRepository caracteristicaRepository;

    @Autowired
    public CaracteristicaServiceImp(CaracteristicaRepository caracteristicaRepository, CaracteristicaMapper caracteristicaMapper) {
        this.caracteristicaMapper = caracteristicaMapper;
        this.caracteristicaRepository = caracteristicaRepository;
    }
    
    @Override
    public List<CaracteristicaDto> obtenerCaracteristica(){
    	
    	List<Caracteristica> listCaracteristicaAux = this.caracteristicaRepository.findAll();
    	
    	return CaracteristicaMapper.INSTANCE.listCaracteristicatoCaracteristicaDTO(listCaracteristicaAux);
    	
    }

    @Override
    public CaracteristicaDto crearCaracteristica(Caracteristica caracteristica) {

        caracteristicaRepository.save(caracteristica);

        return caracteristicaMapper.caracteristiasToCaracteristicasDto(caracteristica);
    }

    @Override
    public CaracteristicaDto obtenerCaracteristicaPorId(Long id) {
        Caracteristica caracteristica = caracteristicaRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No se encontraó ninguna caracteristica con el id: " + id));

        return caracteristicaMapper.caracteristiasToCaracteristicasDto(caracteristica);
    }
}
