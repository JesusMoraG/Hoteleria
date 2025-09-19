package com.tcg.commons.dto;

import com.tcg.commons.enums.EstadoReserva;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ReservaResponse(
		 Long id,
		    String huespedNombre,
		    String huespedApellido,
		    LocalDate fechaEntrada,
		    LocalDate fechaSalida,
		    int noches,
		    BigDecimal total,
		    EstadoReserva estado
) {}
