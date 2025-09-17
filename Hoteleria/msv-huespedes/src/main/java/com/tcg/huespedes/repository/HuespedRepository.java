package com.tcg.huespedes.repository;

import com.tcg.huespedes.model.Huesped;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HuespedRepository extends JpaRepository<Huesped, Long> {
    boolean existsByEmail(String email);
    Optional<Huesped> findByEmail(String email);
}
