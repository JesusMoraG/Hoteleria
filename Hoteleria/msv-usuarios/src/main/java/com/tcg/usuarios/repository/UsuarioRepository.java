package com.tcg.usuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcg.usuarios.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    boolean existsByUsername(String username);
}
