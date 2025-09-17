package com.tcg.roles.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcg.roles.model.Rol;

public interface RolRepository extends JpaRepository<Rol, Long> {
    boolean existsByNombre(String nombre);
    
    Optional<Rol> findByNombreIgnoreCase(String nombre);

}
