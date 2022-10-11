package com.house.digital.service.imp;

import com.house.digital.dto.ImagenDto;
import com.house.digital.entity.Imagen;
import com.house.digital.exception.ResourceNotFoundException;
import com.house.digital.mapper.ImageneMapper;
import com.house.digital.repository.ImagenRepository;
import com.house.digital.service.ImagenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImagenServiceImp implements ImagenService {

    private ImageneMapper imageneMapper;
    private ImagenRepository imagenRepository;

    @Autowired
    public ImagenServiceImp(ImageneMapper imageneMapper, ImagenRepository imagenRepository) {
        this.imageneMapper = imageneMapper;
        this.imagenRepository = imagenRepository;
    }

    @Override
    public ImagenDto crearImagen(Imagen imagen) {
        imagenRepository.save(imagen);
        return imageneMapper.imagenToImagenDto(imagen);
    }


    @Override
    public ImagenDto obtenerImagenPorId(Long id) {
        Imagen imagen = imagenRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No se encontraó ninguna imagen con el id: " + id));

        return imageneMapper.imagenToImagenDto(imagen);
    }
}
