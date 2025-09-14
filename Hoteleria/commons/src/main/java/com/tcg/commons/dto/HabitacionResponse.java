package com.tcg.commons.dto;

public record HabitacionResponse(
    Long id,
    String numero,
    String tipo,
    Double precio
) {}
