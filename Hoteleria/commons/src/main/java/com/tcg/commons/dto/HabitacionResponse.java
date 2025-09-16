package com.tcg.commons.dto;

import java.math.BigDecimal;

public record HabitacionResponse(
    Long id,
    Integer numero,
    String tipo,
    String descripcion,
    BigDecimal precio,
    Integer capacidad,
    String estado
) {}
