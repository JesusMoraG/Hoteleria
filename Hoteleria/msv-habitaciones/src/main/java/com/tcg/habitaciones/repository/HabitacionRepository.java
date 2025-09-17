package com.tcg.habitaciones.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.tcg.habitaciones.model.Habitacion;

import java.util.Optional;

public interface HabitacionRepository extends JpaRepository<Habitacion, Long> {
    Optional<Habitacion> findByNumero(Integer numero);
    boolean existsByNumero(Integer  numero);
}
