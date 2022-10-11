package com.house.digital.mapper;
import com.house.digital.dto.ProductoDTO;
import com.house.digital.entity.Producto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {CaracteristicaMapper.class, ImageneMapper.class, CategoriaMapper.class, CiudadMapper.class, PoliticaMapper.class, ReservaMapper.class})
public interface ProductoMapper {

    ProductoDTO productoToProductoDto(Producto producto);

    Producto productDTOToProducto(ProductoDTO productoDTO);

    List<ProductoDTO> listProductoToListProductoDto(List<Producto> listaProducto);
}