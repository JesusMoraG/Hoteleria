package com.tcg.commons.dto;

import jakarta.validation.constraints.*;

public record HuespedRequest(
    @NotBlank(message = "El nombre es obligatorio")
    String nombre,

    @NotBlank(message = "El apellido es obligatorio")
    String apellido,

    @NotBlank(message = "El documento es obligatorio")
    String documento
) {}
