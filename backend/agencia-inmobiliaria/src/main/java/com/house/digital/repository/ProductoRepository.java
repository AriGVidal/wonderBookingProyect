package com.house.digital.repository;

import com.house.digital.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    @Query("SELECT p from Producto p where p.ciudad.id = ?1 ")
    List<Producto> findByCiudad(Long ciudadId);

    @Query("SELECT p from Producto p where p.ciudad.id = ?1 and p.id not in  " +
            "(select p1.id from Producto p1 inner join Reserva r on p1.id = r.producto.id where p1.ciudad.id = ?1 and " +
            "(((r.checkIn >= ?2 and r.checkIn <= ?3) or (r.checkOut >= ?2 and r.checkOut <= ?3)) or" +
            "((?2 >= r.checkIn and ?2 <= r.checkOut) or (?3 >= r.checkIn and ?3 <= r.checkOut)))" +
            ")")
    List<Producto> findConCiudadYFechas(Long ciudadId, LocalDateTime checkIn, LocalDateTime checkOut);

    @Query("SELECT p from Producto p where p.id not in  " +
            "(select p1.id from Producto p1 inner join Reserva r on p1.id = r.producto.id where " +
            "(((r.checkIn >= ?1 and r.checkIn <= ?2) or (r.checkOut >= ?1 and r.checkOut <= ?2)) or" +
            "((?1 >= r.checkIn and ?1 <= r.checkOut) or (?2 >= r.checkIn and ?2 <= r.checkOut)))" +
            ")")
    List<Producto> findConfechas(LocalDateTime checkIn, LocalDateTime checkOut);


    @Query("SELECT p from Producto p where p.categoria.id = ?1 ")
    List<Producto> findByCategoria(Long categoriaId);
}
