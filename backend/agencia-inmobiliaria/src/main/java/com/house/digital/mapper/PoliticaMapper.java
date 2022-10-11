package com.house.digital.mapper;

import com.house.digital.dto.PoliticaDTO;
import com.house.digital.entity.Politica;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PoliticaMapper {
    PoliticaDTO politicaToPoliticaDto(Politica politica);

    List<Politica> listPoliticaDtotoPolitica(List<PoliticaDTO> listaPoliticaDTODTO);

    List<PoliticaDTO> listaPoliticaToPoliticaDTO(List<Politica> listaPolitica);

}
