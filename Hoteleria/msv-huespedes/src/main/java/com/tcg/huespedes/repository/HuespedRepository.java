package com.tcg.huespedes.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.tcg.huespedes.models.Huesped;

public interface HuespedRepository extends JpaRepository<Huesped, Long> {
    Optional<Huesped> findByEmail(String email);
    Optional<Huesped> findByTelefono(String telefono);
    boolean existsByEmail(String email);
    boolean existsByTelefono(String telefono);
}
