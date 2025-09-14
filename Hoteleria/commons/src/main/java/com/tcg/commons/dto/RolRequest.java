package com.tcg.commons.dto;

import jakarta.validation.constraints.*;

public record RolRequest(
    @NotBlank(message = "El nombre del rol es obligatorio")
    String nombre
) {}
