package com.house.digital.repository;

import com.house.digital.entity.Politica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PoliticaRepository extends JpaRepository<Politica, Long> {
    @Query("SELECT p from Politica p where p.producto.id = ?1 ")
    List<Politica> findByProducto(Long productoId);
}
