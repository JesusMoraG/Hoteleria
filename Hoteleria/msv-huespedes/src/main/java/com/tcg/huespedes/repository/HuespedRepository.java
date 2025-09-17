package com.tcg.huespedes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcg.huespedes.model.Huesped;


public interface HuespedRepository extends JpaRepository<Huesped, Long> {
    boolean existsByDocumento(String documento);
    boolean existsByEmail(String email);
    boolean existsByTelefono(String telefono);
}

