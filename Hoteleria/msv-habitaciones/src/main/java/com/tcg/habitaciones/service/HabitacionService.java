package com.tcg.habitaciones.service;

import java.util.List;
import com.tcg.commons.dto.HabitacionRequest;
import com.tcg.commons.dto.HabitacionResponse;

public interface HabitacionService {
    List<HabitacionResponse> listarTodos();
    HabitacionResponse obtenerPorId(Long id);
    HabitacionResponse insertar(HabitacionRequest request);
    HabitacionResponse actualizar(Long id, HabitacionRequest request);
    void eliminar(Long id);
}
