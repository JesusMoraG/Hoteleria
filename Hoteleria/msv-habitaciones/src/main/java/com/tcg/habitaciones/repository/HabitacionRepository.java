package com.tcg.habitaciones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcg.habitaciones.model.Habitacion;

@Repository
public interface HabitacionRepository extends JpaRepository<Habitacion, Long> {
    
}

