package com.tcg.commons.dto;

import java.time.LocalDate;

public record ReservaResponse(
    Long id,
    Long idHuesped,
    Long idHabitacion,
    LocalDate fechaInicio,
    LocalDate fechaFin
) {}
