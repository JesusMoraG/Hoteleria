package com.tcg.commons.dto;

import jakarta.validation.constraints.*;

public record HabitacionRequest(
    @NotBlank(message = "El número es obligatorio")
    String numero,

    @NotBlank(message = "El tipo es obligatorio")
    String tipo,

    @NotNull(message = "El precio es obligatorio")
    @Min(value = 1, message = "El precio debe ser mayor a 0")
    Double precio
) {}
