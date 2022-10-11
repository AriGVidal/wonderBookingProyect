package com.house.digital.service.imp;

import com.house.digital.dto.CaracteristicaDto;
import com.house.digital.dto.CategoriaDto;
import com.house.digital.dto.CiudadDto;
import com.house.digital.dto.ImagenDto;
import com.house.digital.dto.PoliticaDTO;
import com.house.digital.dto.ProductoDTO;
import com.house.digital.dto.ProductoPostDto;
import com.house.digital.entity.Producto;
import com.house.digital.exception.ResourceNotFoundException;
import com.house.digital.mapper.CaracteristicaMapper;
import com.house.digital.mapper.CategoriaMapper;
import com.house.digital.mapper.CiudadMapper;
import com.house.digital.mapper.ImageneMapper;
import com.house.digital.mapper.PoliticaMapper;
import com.house.digital.mapper.ProductoMapper;
import com.house.digital.repository.ProductoRepository;
import com.house.digital.service.CaracteristicaService;
import com.house.digital.service.CategoriaService;
import com.house.digital.service.CiudadService;
import com.house.digital.service.ImagenService;
import com.house.digital.service.PoliticaService;
import com.house.digital.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImp implements ProductoService {

    private ProductoMapper productoMapper;
    private ProductoRepository productoRepository;
    private CiudadService ciudadService;
    private CategoriaService categoriaService;
    private CaracteristicaService caracteristicaService;
    private ImagenService imagenService;
    private PoliticaService politicaService;
    private CategoriaMapper categoriaMapper;
    private CiudadMapper ciudadMapper;
    private CaracteristicaMapper caracteristicaMapper;
    private ImageneMapper imageneMapper;
    private PoliticaMapper politicaMapper;
    
    private static final String MESSAGE = "No se encontraron productos con el id: ";


    @Autowired
    public ProductoServiceImp(ProductoMapper productoMapper, ProductoRepository productoRepository,
                              CiudadService ciudadService, CategoriaService categoriaService,
                              PoliticaService politicaService,
                              CategoriaMapper categoriaMapper, CiudadMapper ciudadMapper,
                              CaracteristicaService caracteristicaService, ImagenService imagenService,
                              CaracteristicaMapper caracteristicaMapper, ImageneMapper imageneMapper, PoliticaMapper politicaMapper) {
        this.productoMapper = productoMapper;
        this.productoRepository = productoRepository;
        this.ciudadService = ciudadService;
        this.categoriaService = categoriaService;
        this.politicaService = politicaService;
        this.categoriaMapper = categoriaMapper;
        this.ciudadMapper = ciudadMapper;
        this.caracteristicaMapper = caracteristicaMapper;
        this.imageneMapper = imageneMapper;
        this.caracteristicaService = caracteristicaService;
        this.imagenService = imagenService;
        this.politicaMapper = politicaMapper;
    }
    
    @Override
    public ProductoDTO actualizarProducto(ProductoPostDto productoPostDto) {
    	
    	if(this.productoRepository.existsById(productoPostDto.getId())) {
    		
    		CiudadDto ciudad = ciudadService.obtenerCiudadPorId(productoPostDto.getIdCiudad());
            CategoriaDto categoria = categoriaService.obtenerCategoriaPorId(productoPostDto.getIdCategoria());

            Producto producto = new Producto(productoPostDto.getId(),productoPostDto.getNombre(),
                    productoPostDto.getDescripcion(), productoPostDto.getTitulo(), productoPostDto.getUbicacion(),
                    ciudadMapper.ciudadDtoToCiudad(ciudad), categoriaMapper.categoriaDtoToCategoria(categoria));
            
            Producto savedProduct = this.productoRepository.save(producto);

            List<ImagenDto>imagenesDTO = new ArrayList<>();
            List<CaracteristicaDto>caracteristicasDTO = new ArrayList<>();
            List<PoliticaDTO>politicasDTO = new ArrayList<>();

            imageneMapper.listImagenDtotoImagen(productoPostDto.getImagenes()).forEach(i -> {
                i.setProducto(savedProduct);
                ImagenDto imagen = this.imagenService.crearImagen(i);
                imagenesDTO.add(imagen);

            });
            caracteristicaMapper.listCaracteristicaDtotoCaracteristica(productoPostDto.getCaracteristicas()).forEach(i -> {
                i.setProducto(savedProduct);
               CaracteristicaDto caracteristicaDto = this.caracteristicaService.crearCaracteristica(i);
               caracteristicasDTO.add(caracteristicaDto);
            });

            politicaMapper.listPoliticaDtotoPolitica(productoPostDto.getPoliticas()).forEach(i -> {
                i.setProducto(savedProduct);
                PoliticaDTO politicaDTO = this.politicaService.crearPolitica(i);
                politicasDTO.add(politicaDTO);
            });

            ProductoDTO productoDTO =  productoMapper.productoToProductoDto(producto);
            productoDTO.setCaracteristicas(caracteristicasDTO);
            productoDTO.setImagenes(imagenesDTO);
            productoDTO.setPoliticas(politicasDTO);
            return productoDTO;
            
    	} else {
    		throw new ResourceNotFoundException(MESSAGE + productoPostDto.getId());
    	}
    	
    }

    @Override
    public ProductoDTO crearProducto(ProductoPostDto productoPostDto) {
        CiudadDto ciudad = ciudadService.obtenerCiudadPorId(productoPostDto.getIdCiudad());
        CategoriaDto categoria = categoriaService.obtenerCategoriaPorId(productoPostDto.getIdCategoria());

        Producto producto = new Producto(productoPostDto.getNombre(),
                productoPostDto.getDescripcion(), productoPostDto.getTitulo(), productoPostDto.getUbicacion(),
                ciudadMapper.ciudadDtoToCiudad(ciudad), categoriaMapper.categoriaDtoToCategoria(categoria));
        Producto savedProduct = this.productoRepository.save(producto);

        List<ImagenDto>imagenesDTO = new ArrayList<>();
        List<CaracteristicaDto>caracteristicasDTO = new ArrayList<>();
        List<PoliticaDTO>politicasDTO = new ArrayList<>();


        imageneMapper.listImagenDtotoImagen(productoPostDto.getImagenes()).forEach(i -> {
            i.setProducto(savedProduct);
            ImagenDto imagen = this.imagenService.crearImagen(i);
            imagenesDTO.add(imagen);

        });
        caracteristicaMapper.listCaracteristicaDtotoCaracteristica(productoPostDto.getCaracteristicas()).forEach(i -> {
            i.setProducto(savedProduct);
           CaracteristicaDto caracteristicaDto = this.caracteristicaService.crearCaracteristica(i);
           caracteristicasDTO.add(caracteristicaDto);
        });

        politicaMapper.listPoliticaDtotoPolitica(productoPostDto.getPoliticas()).forEach(i -> {
            i.setProducto(savedProduct);
            PoliticaDTO politicaDTO = this.politicaService.crearPolitica(i);
            politicasDTO.add(politicaDTO);
        });

        ProductoDTO productoDTO =  productoMapper.productoToProductoDto(producto);
        productoDTO.setCaracteristicas(caracteristicasDTO);
        productoDTO.setImagenes(imagenesDTO);
        productoDTO.setPoliticas(politicasDTO);
        return productoDTO;
    }

    @Override
    public ProductoDTO obtenerProductoPorId(Long id) {
        Producto producto = productoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(MESSAGE + id));

        return productoMapper.productoToProductoDto(producto);
    }

    @Override
    public List<ProductoDTO> obtenerProductosPorCiudadId(Long ciudadId, String checkIn, String checkOut) {
        String message;
        List<Producto>productos;

        if(Optional.ofNullable(checkIn).isPresent() && Optional.ofNullable(checkOut).isPresent()) {
            LocalDateTime checkInAsDate = LocalDate.parse(checkIn).atStartOfDay();
            LocalDateTime checkOutAsDate = LocalDate.parse(checkOut).atStartOfDay();
            productos = this.productoRepository.findConCiudadYFechas(ciudadId, checkInAsDate, checkOutAsDate);
            message = String.format("No hay productos encontrados con ciudad id : %s en fecha check in %s y " +
                    "fecha check out %s", ciudadId, checkIn, checkOut);
        }
        else{
            productos = this.productoRepository.findByCiudad(ciudadId);
            message = String.format("No hay productos encontrados con ciudad id : %s", ciudadId);
        }
        if (!productos.isEmpty()) {
            return productoMapper.listProductoToListProductoDto(productos);
        } else {
            throw new ResourceNotFoundException(message);
        }
    }


    @Override
    public List<ProductoDTO> obtenerProductosPorCategoriaId(Long categoriaId) {
        List<Producto> listaProductos = productoRepository.findByCategoria(categoriaId);
        if(!listaProductos.isEmpty()) {
            return productoMapper.listProductoToListProductoDto(listaProductos);
        }
        else {
            throw new ResourceNotFoundException(String.format("No hay productos encontrados con categoria id: %s", categoriaId));
        }
    }

    @Override
    public List<ProductoDTO> obtenerProductos(String checkIn, String checkOut) {
        String message;
        List<Producto>productos;

        if(Optional.ofNullable(checkIn).isPresent() && Optional.ofNullable(checkOut).isPresent()) {
            LocalDateTime checkInAsDate = LocalDate.parse(checkIn).atStartOfDay();
            LocalDateTime checkOutAsDate = LocalDate.parse(checkOut).atStartOfDay();

            productos = this.productoRepository.findConfechas(checkInAsDate, checkOutAsDate);
            message = String.format("No hay productos encontrados confecha check in %s y " +
                    "fecha check out %s", checkIn, checkOut);
        }
        else {
            productos = productoRepository.findAll();
            message = "No se encontraron productos ";
        }

        if(!productos.isEmpty()) {
            Collections.shuffle(productos);
            return productoMapper.listProductoToListProductoDto(productos);
        }
        else {
            throw new ResourceNotFoundException(message);
        }
    }

    @Override
    public void eliminarProducto(Long id) {
        Producto producto = productoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(MESSAGE + id));

        productoRepository.delete(producto);
    }

}

