package com.tcg.reservas.service;

import com.tcg.commons.dto.ReservaRequest;
import com.tcg.commons.dto.ReservaResponse;
import com.tcg.commons.service.CommonService;

import java.util.List;

public interface ReservaService extends CommonService<ReservaRequest, ReservaResponse>{
    List<ReservaResponse> listarTodos();   

    ReservaResponse obtenerPorId(Long id);

    ReservaResponse insertar(ReservaRequest dto);

    ReservaResponse actualizar(Long id, ReservaRequest dto);

    void eliminar(Long id);
}
