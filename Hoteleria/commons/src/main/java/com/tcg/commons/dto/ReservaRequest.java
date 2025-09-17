package com.tcg.commons.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public record ReservaRequest(
    @NotNull(message = "Debe indicar un huésped")
    Long huespedId,

    @NotNull(message = "Debe indicar una habitación")
    Long habitacionId,

    @NotNull(message = "La fecha de inicio es obligatoria")
    LocalDate fechaEntrada,

    @NotNull(message = "La fecha de fin es obligatoria")
    LocalDate fechaSalida
) {}
