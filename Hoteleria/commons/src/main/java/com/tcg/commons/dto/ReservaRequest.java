package com.tcg.commons.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tcg.commons.enums.EstadoReserva;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public record ReservaRequest(

    @NotNull(message = "Debe indicar un huésped")
    @Positive(message = "El id del huésped debe ser un número positivo")
    Long huespedId,

    @NotNull(message = "Debe indicar una habitación")
    @Positive(message = "El id de la habitación debe ser un número positivo")
    Long habitacionId,

    @NotNull(message = "La fecha de entrada es obligatoria")
    @FutureOrPresent(message = "La fecha de entrada debe ser hoy o una fecha futura")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    LocalDate fechaEntrada,

    @NotNull(message = "La fecha de salida es obligatoria")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    LocalDate fechaSalida,

    
    @Min(value = 1, message = "Las noches deben ser al menos 1")
    int noches,

    
    @DecimalMin(value = "0.00", inclusive = true, message = "El total no puede ser negativo")
    BigDecimal total,

   
    @Pattern(regexp = "^[A-Za-z0-9 _\\-]{1,50}$", message = "Estado inválido")
    EstadoReserva estado

) {

    @AssertTrue(message = "La fecha de salida debe ser posterior a la fecha de entrada")
    public boolean isFechaSalidaPosterior() {
        if (fechaEntrada == null || fechaSalida == null) return true;
        return fechaSalida.isAfter(fechaEntrada);
    }
}
