package com.tcg.commons.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ReservaResponse(
        Long id,
        Long huespedId,
        Long habitacionId,
        LocalDate fechaEntrada,
        LocalDate fechaSalida,
        Integer noches,
        BigDecimal total,
        String estado
) {}
