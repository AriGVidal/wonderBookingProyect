package com.house.digital.repository;

import com.house.digital.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    @Query("SELECT r from Reserva r where r.producto.id = ?1 " +
            "and ((((r.checkIn >= ?2 and r.checkIn <= ?3) or (r.checkOut >= ?2 and r.checkOut <= ?3)))" +
            "or (((?2 >= r.checkIn and ?3 <= r.checkOut) or (?3 >= r.checkIn and ?3 <= r.checkOut)))) ")
    List<Reserva> reservasProductosPorFechas(Long productoId, LocalDateTime checkIn, LocalDateTime checkOut);

    @Query("SELECT r from Reserva r where r.producto.id = ?1 ")
    List<Reserva> reservasPorProducto(Long productoId);

}
