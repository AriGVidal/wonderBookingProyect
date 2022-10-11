package com.house.digital.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.house.digital.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{	
	
	Optional<Usuario> findByEmail(String email);

}
