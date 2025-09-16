package com.tcg.commons.dto;

import jakarta.validation.constraints.*;

public record UsuarioRequest(
    @NotBlank(message = "El nombre de usuario es obligatorio")
    String username,

    @NotBlank(message = "La contraseña es obligatoria")
    String password,

    @NotNull(message = "Debe tener un rol asignado")
    String rol
) {}
