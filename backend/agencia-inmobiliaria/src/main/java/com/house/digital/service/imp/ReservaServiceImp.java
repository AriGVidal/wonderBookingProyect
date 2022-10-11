package com.house.digital.service.imp;

import com.house.digital.dto.ProductoDTO;
import com.house.digital.dto.ReservaDTO;
import com.house.digital.entity.Producto;
import com.house.digital.entity.Reserva;
import com.house.digital.entity.Usuario;
import com.house.digital.exception.ResourceNotFoundException;
import com.house.digital.mapper.ProductoMapper;
import com.house.digital.mapper.ReservaMapper;
import com.house.digital.repository.ReservaRepository;
import com.house.digital.service.ReservaService;
import com.house.digital.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReservaServiceImp implements ReservaService {
    private ProductoServiceImp productoServiceImp;
    private ReservaRepository reservaRepository;
    private ReservaMapper reservaMapper;
    private ProductoMapper productoMapper;
    private UsuarioService usuarioService;

    @Autowired
    public ReservaServiceImp(ReservaRepository reservaRepository, ProductoServiceImp productoServiceImp, ProductoMapper productoMapper, ReservaMapper reservaMapper, UsuarioService usuarioService) {
        this.productoServiceImp = productoServiceImp;
        this.reservaRepository = reservaRepository;
        this.productoMapper = productoMapper;
        this.reservaMapper = reservaMapper;
        this.usuarioService = usuarioService;
    }

    @Override
    public ReservaDTO crearReserva(ReservaDTO reservaDTO, String userName) {
        ProductoDTO productoDTO = this.productoServiceImp.obtenerProductoPorId(reservaDTO.getProductoId());
        Producto producto = this.productoMapper.productDTOToProducto(productoDTO);
        Usuario usuario = this.usuarioService.getByUserName(userName);
        Reserva reserva = new Reserva(reservaDTO.getCheckIn(), reservaDTO.getCheckOut());
        reserva.setUsuario(usuario);
        reserva.setProducto(producto);
        this.reservaRepository.save(reserva);
        reservaDTO.setId(reserva.getId());
        return reservaDTO;
    }

    @Override
    public List<ReservaDTO> reservasPorProducto(Long productoId, String checkIn, String checkOut) {
        String message;
        List<Reserva>reservas;
        if(Optional.ofNullable(checkIn).isPresent() && Optional.ofNullable(checkOut).isPresent()){
            LocalDateTime checkInAsDate = LocalDate.parse(checkIn).atStartOfDay();
            LocalDateTime checkOutAsDate = LocalDate.parse(checkOut).atStartOfDay();
            reservas = this.reservaRepository.reservasProductosPorFechas(productoId, checkInAsDate, checkOutAsDate);
            message = String.format("No hay reservas encontradas para product : %s", productoId);
        }
        else {
            reservas = this.reservaRepository.reservasPorProducto(productoId);
            message = String.format("No hay reservas encontradas para product : %s", productoId);

        }
        if(!reservas.isEmpty()) {
          return this.reservaMapper.listaReservaToReservaDTO(reservas);
        }
        else {
            throw new ResourceNotFoundException(message);
        }
    }

    @Override
    public List<ReservaDTO> reservasPorUsuario(String userName) {
        Usuario usuario = this.usuarioService.getByUserName(userName);
        List<Reserva>reservas = usuario.getReservas();
        if(!reservas.isEmpty()) {
            List<ReservaDTO>reservaDTOS = reservas.stream().map(r ->  new ReservaDTO(r.getId(), r.getCheckIn(), r.getCheckOut(), r.getProducto().getId()))
                    .collect(Collectors.toList());
            return reservaDTOS;
        }
        else {
            throw new ResourceNotFoundException(String.format("No hay reservas encontrados para el usuario : %s", userName));
        }

    }



}
