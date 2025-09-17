package com.tcg.habitaciones.service;

import java.util.List;
import com.tcg.commons.dto.HabitacionRequest;
import com.tcg.commons.dto.HabitacionResponse;
import com.tcg.commons.service.CommonService;

public interface HabitacionService  extends CommonService<HabitacionRequest, HabitacionResponse>{
    List<HabitacionResponse> listarTodos();
    HabitacionResponse obtenerPorId(Long id);
    HabitacionResponse insertar(HabitacionRequest request);
    HabitacionResponse actualizar(Long id, HabitacionRequest request);
    void eliminar(Long id);
}
