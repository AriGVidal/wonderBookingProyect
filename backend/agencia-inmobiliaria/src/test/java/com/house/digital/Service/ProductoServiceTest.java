package com.house.digital.Service;

import com.house.digital.mapper.ProductoMapper;
import com.house.digital.repository.CategoriaRepository;
import com.house.digital.repository.CiudadRepository;
import com.house.digital.repository.ProductoRepository;
import com.house.digital.service.CategoriaService;
import com.house.digital.service.CiudadService;
import com.house.digital.service.imp.ProductoServiceImp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class ProductoServiceTest {

    ProductoMapper productoMapperMock = Mockito.mock(ProductoMapper.class);
    ProductoRepository productoRepositoryMock = Mockito.mock(ProductoRepository.class);
    CiudadService ciudadServiceMock = Mockito.mock(CiudadService.class);
    CategoriaService categoriServiceMock = Mockito.mock(CategoriaService.class);

    @Test
    public void crearProductoTest() {

    }

    @Test
    public void obtenerProductosTest() {

    }

    @Test
    public void obtenerProductoPorIdTest() {

    }

}
