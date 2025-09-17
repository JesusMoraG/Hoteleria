package com.tcg.commons.dto;

public record HuespedResponse(
		Long id,
		String nombre,
		String apellido,
		String documento,
		String email,
	    String telefono,
	    String nacionalidad
) {}
