package com.tcg.commons.service;

import java.util.List;

public interface CommonService<RQ, RS> {
    List<RS> listarTodos();
    RS obtenerPorId(Long id);
    RS insertar(RQ dto);
    RS actualizar(Long id, RQ dto);
    void eliminar(Long id);
}
