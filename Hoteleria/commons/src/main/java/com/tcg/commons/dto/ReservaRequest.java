package com.tcg.commons.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public record ReservaRequest(
    @NotNull(message = "Debe indicar un huésped")
    Long idHuesped,

    @NotNull(message = "Debe indicar una habitación")
    Long idHabitacion,

    @NotNull(message = "La fecha de inicio es obligatoria")
    LocalDate fechaInicio,

    @NotNull(message = "La fecha de fin es obligatoria")
    LocalDate fechaFin
) {}
