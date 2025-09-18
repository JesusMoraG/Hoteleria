package com.tcg.commons.dto;

import com.tcg.commons.enums.TipoDocumento;

public record HuespedResponse(
		 Long id,
	        String nombre,
	        String apellido,
	        String numeroDocumento,
	        TipoDocumento tipoDocumento,
	        String telefono,
	        String email,
	        String nacionalidad
	) {}
