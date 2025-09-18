package com.tcg.commons.dto;

import java.math.BigDecimal;

import com.tcg.commons.enums.EstadoHabitacion;

import jakarta.validation.constraints.*;

public record HabitacionRequest(

	    @NotNull(message = "El número es obligatorio")
	    @Min(value = 1, message = "El número debe ser mayor a 0")
	    Integer numero,

	    @NotBlank(message = "El tipo es obligatorio")
	    @Size(max = 50, message = "El tipo no debe superar los 50 caracteres")
	    String tipo,

	    @Size(max = 255, message = "La descripción no debe superar los 255 caracteres")
	    String descripcion,

	    @NotNull(message = "El precio es obligatorio")
	    @DecimalMin(value = "0.01", message = "El precio debe ser mayor a 0")
	    @Digits(integer = 10, fraction = 2, message = "El precio debe tener máximo 10 dígitos enteros y 2 decimales")
	    BigDecimal precio,

	    @NotNull(message = "La capacidad es obligatoria")
	    @Min(value = 1, message = "La capacidad mínima es 1")
	    Integer capacidad,

	    @NotBlank(message = "El estado es obligatorio")
	    @Pattern(regexp = "Disponible|Ocupada|Limpieza|Mantenimiento", message = "Estado inválido")
	    EstadoHabitacion estado
	    

	) {}
