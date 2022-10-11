package com.house.digital.service;

import com.house.digital.dto.ImagenDto;
import com.house.digital.entity.Imagen;

public interface ImagenService {
    ImagenDto crearImagen(Imagen imagen);

    ImagenDto obtenerImagenPorId(Long id);
}
