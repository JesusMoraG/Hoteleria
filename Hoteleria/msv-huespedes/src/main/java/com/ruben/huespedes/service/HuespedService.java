package com.ruben.huespedes.service;

import com.ruben.huespedes.dto.HuespedRequest;
import com.ruben.huespedes.dto.HuespedResponse;

import java.util.List;
import java.util.Optional;

public interface HuespedService {
    List<HuespedResponse> listar();
    Optional<HuespedResponse> buscar(Long id);
    HuespedResponse crear(HuespedRequest request);
    Optional<HuespedResponse> editar(Long id, HuespedRequest request);
    boolean eliminar(Long id);
}
