package com.house.digital.Service;

import com.house.digital.dto.CategoriaDto;
import com.house.digital.entity.Categoria;
import com.house.digital.mapper.CategoriaMapper;
import com.house.digital.repository.CategoriaRepository;
import com.house.digital.service.imp.CategoriaServiceImp;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)

public class CategoriaServiceTest {
    CategoriaMapper categoriaMapperMock = Mockito.mock(CategoriaMapper.class);
    CategoriaRepository categoriaRepositoryMock = Mockito.mock(CategoriaRepository.class);
    CategoriaServiceImp categoriaService = new CategoriaServiceImp(categoriaRepositoryMock, categoriaMapperMock);


    @Test
    public void eliminarCategoriaTest()  {
        Categoria categoria = new Categoria(1L, "hotel", "hotel", "imagen1");
        Mockito.when(this.categoriaRepositoryMock.findById(1L)).thenReturn(Optional.of(categoria));
        categoriaService.eliminarCategoria(1L);
        Mockito.verify(this.categoriaRepositoryMock, Mockito.times(1)).delete(categoria);
    }

    @Test
    public void actualizarCategoriaTest() {
        Categoria categoria = new Categoria(1L, "Hotel", "Hotel 1", "abc");
        CategoriaDto categoriaDTO = new CategoriaDto(1L, "Hotel", "Hotel 1", "abc");
        Mockito.when(this.categoriaRepositoryMock.existsById(categoria.getId())).thenReturn(true);
        Mockito.when(this.categoriaMapperMock.categoriaDtoToCategoria(categoriaDTO)).thenReturn(categoria);
        Mockito.when(this.categoriaMapperMock.categoriaToCategoriaDto(categoria)).thenReturn(categoriaDTO);
        Mockito.when(this.categoriaRepositoryMock.save(categoria)).thenReturn(categoria);
        Assert.assertEquals(categoriaDTO, categoriaService.actualizarCategoria(categoriaDTO));
    }

    @Test
    public void crearCategoriaTest() {
        Categoria categoria = new Categoria(3L, "Hostel2", "Hostel", "urls");
        CategoriaDto categoriaDTO = new CategoriaDto(3L, "Hostel2", "Hostel", "urls");
        Mockito.when(this.categoriaRepositoryMock.save(categoria)).thenReturn(categoria);
        Mockito.when(this.categoriaMapperMock.categoriaDtoToCategoria(categoriaDTO)).thenReturn(categoria);
        Mockito.when(this.categoriaMapperMock.categoriaToCategoriaDto(categoria)).thenReturn(categoriaDTO);
        Assert.assertEquals(categoriaDTO, categoriaService.crearCategoria(categoriaDTO));
    }

    @Test
    public void obtenerCategoriasTest() {
        List<CategoriaDto> categoriaList = new ArrayList<>();
        categoriaList.add(new CategoriaDto(1L, "casa1", "casa", "url"));
        categoriaList.add(new CategoriaDto(2L, "cabaña", "cabaña1", "url2"));
        List<Categoria> catagoriaJPAlist = new ArrayList<>();
        catagoriaJPAlist.add(new Categoria(1L, "casa1", "casa", "url"));
        catagoriaJPAlist.add(new Categoria(2L, "cabaña", "cabaña1", "url2"));
        Mockito.when(this.categoriaRepositoryMock.findAll()).thenReturn(catagoriaJPAlist);
        Mockito.when(this.categoriaMapperMock.listaCategoriaToListaCategoriaDto(catagoriaJPAlist)).thenReturn(categoriaList);
        List<CategoriaDto> categorias = categoriaService.obtenerCategorias();
        Assert.assertFalse(categorias.isEmpty());
        Assert.assertEquals(2, categorias.size());
        Assert.assertEquals(categoriaList, categorias);
    }

    @Test
    public void obtenerCategoriaPorId() {
        CategoriaDto categoriaDto = new CategoriaDto(1L, "casa1", "casa", "url");
        Categoria categoria =  new Categoria(1L, "casa1", "casa", "url");
        Mockito.when(this.categoriaRepositoryMock.findById(1L)).thenReturn(Optional.of(categoria));
        Mockito.when(this.categoriaMapperMock.categoriaToCategoriaDto(categoria)).thenReturn(categoriaDto);
        Assert.assertEquals(categoriaDto, this.categoriaService.obtenerCategoriaPorId(1L));
    }
}
