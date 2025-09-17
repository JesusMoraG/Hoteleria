package com.tcg.commons.dto;

import jakarta.validation.constraints.*;

public record HuespedRequest(
    @NotBlank(message = "El nombre es obligatorio")
    String nombre,

    @NotBlank(message = "El apellido es obligatorio")
    String apellido,

    @NotBlank(message = "El documento es obligatorio")
    String documento,
    
    @NotBlank(message = "El email es obligatorio")
    @Email(message = "El formato del email no es válido")
    String email,
    
    @NotBlank(message = "El teléfono es obligatorio")
    String telefono,

    @NotBlank(message = "La nacionalidad es obligatoria")
    String nacionalidad

) {}
