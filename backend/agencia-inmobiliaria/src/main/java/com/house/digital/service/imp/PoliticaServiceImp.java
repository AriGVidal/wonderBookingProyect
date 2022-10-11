package com.house.digital.service.imp;

import com.house.digital.dto.PoliticaDTO;
import com.house.digital.dto.PoliticaGroupResponseDTO;
import com.house.digital.entity.Politica;
import com.house.digital.exception.ResourceNotFoundException;
import com.house.digital.mapper.PoliticaMapper;
import com.house.digital.repository.PoliticaRepository;
import com.house.digital.service.PoliticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PoliticaServiceImp implements PoliticaService {

    private PoliticaMapper politicaMapper;
    private PoliticaRepository politicaRepository;

    @Autowired
    public PoliticaServiceImp(PoliticaMapper politicaMapper, PoliticaRepository politicaRepository) {
        this.politicaMapper = politicaMapper;
        this.politicaRepository = politicaRepository;
    }

    @Override
    public PoliticaDTO crearPolitica(Politica politica) {
        politicaRepository.save(politica);
        return politicaMapper.politicaToPoliticaDto(politica);
    }

    @Override
    public List<PoliticaGroupResponseDTO> listaPoliticasPorProducto(Long productoId) {
        List<Politica> listaPoliticas = this.politicaRepository.findByProducto(productoId);

        if(!listaPoliticas.isEmpty()) {
            List<PoliticaDTO>politicaDTOS = politicaMapper.listaPoliticaToPoliticaDTO(listaPoliticas);
            return this.politicasPorNombre(politicaDTOS);
        }
        else {
            throw new ResourceNotFoundException(String.format("No hay politicas encontrados para product : %s", productoId));
        }
    }

    @Override
    public List<PoliticaGroupResponseDTO> politicasPorNombre(List<PoliticaDTO> politicaDTOS) {
        Map<String, List<PoliticaDTO>> map =  politicaDTOS.stream().collect(Collectors.groupingBy(PoliticaDTO::getNombre));
        return map
                .entrySet().stream().map(e -> new PoliticaGroupResponseDTO(e.getKey(), e.getValue().stream().map(PoliticaDTO::getDescripcion).collect(Collectors.toList())))
                .collect(Collectors.toList());
    }

    @Override
    public List<PoliticaDTO> getPoliticas(Long productoId) {
        List<Politica> listaPoliticas = this.politicaRepository.findByProducto(productoId);

        if(!listaPoliticas.isEmpty()) {
            List<PoliticaDTO>politicaDTOS = politicaMapper.listaPoliticaToPoliticaDTO(listaPoliticas);
            return politicaDTOS;
        }
        else {
            throw new ResourceNotFoundException(String.format("No hay politicas encontrados para product : %s", productoId));
        }    }


}

