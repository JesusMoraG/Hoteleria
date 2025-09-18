package com.tcg.commons.dto;

import java.math.BigDecimal;

import com.tcg.commons.enums.EstadoHabitacion;

public record HabitacionResponse(
	    Long id,
	    Integer numero,
	    String tipo,
	    String descripcion,
	    BigDecimal precio,
	    Integer capacidad,
	    EstadoHabitacion estado
	) {}
