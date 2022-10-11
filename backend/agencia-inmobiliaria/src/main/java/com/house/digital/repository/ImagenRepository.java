package com.house.digital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.house.digital.entity.Imagen;

@Repository
public interface ImagenRepository extends JpaRepository<Imagen, Long>{

}
