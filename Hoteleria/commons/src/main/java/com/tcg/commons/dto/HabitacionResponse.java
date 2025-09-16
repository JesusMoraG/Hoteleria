package com.tcg.commons.dto;

public record HabitacionResponse(
	    Long id,
	    Integer numero,
	    String tipo,
	    String descripcion,
	    Double precio,
	    Integer capacidad,
	    String estado
	) {}
