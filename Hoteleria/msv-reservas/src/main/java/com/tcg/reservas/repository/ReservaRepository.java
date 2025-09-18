package com.tcg.reservas.repository;

import com.tcg.reservas.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    List<Reserva> findByHabitacionIdAndFechaEntradaLessThanEqualAndFechaSalidaGreaterThanEqual(
            Long habitacionId,
            LocalDate fechaSalida,
            LocalDate fechaEntrada
    );
}
