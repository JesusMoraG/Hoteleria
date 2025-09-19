package com.tcg.commons.dto;

import com.tcg.commons.enums.TipoDocumento;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;

public record HuespedRequest(
    @NotBlank(message = "El nombre es obligatorio")
    String nombre,

    @NotBlank(message = "El apellido es obligatorio")
    String apellido,

    @NotNull(message = "El documento es obligatorio")
    @Enumerated(EnumType.STRING)
    TipoDocumento tipoDocumento,
    
    @NotBlank(message = "El numero de documento es obligatorio")
    String numeroDocumento,
    
    @NotBlank(message = "El email es obligatorio")
    @Email(message = "El formato del email no es válido")
    String email,
    
    @NotBlank(message = "El teléfono es obligatorio")
    String telefono,

    @NotBlank(message = "La nacionalidad es obligatoria")
    String nacionalidad

) {}
