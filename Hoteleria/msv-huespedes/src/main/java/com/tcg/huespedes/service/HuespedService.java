package com.tcg.huespedes.service;

import java.util.List;
import java.util.Optional;
import com.tcg.huespedes.models.Huesped;

public interface HuespedService {
    Huesped crear(Huesped h);
    List<Huesped> listar();
    Optional<Huesped> buscarPorId(Long id);
    Huesped actualizar(Long id, Huesped h);
    void eliminar(Long id);
}
