package com.tcg.huespedes.service;
import com.tcg.huespedes.model.Huesped;
import java.util.List;
import java.util.Optional;
public interface HuespedService {
    List<Huesped> listar();
    Optional<Huesped> buscar(Long id);
    Huesped crear(Huesped h);
    Optional<Huesped> editar(Long id, Huesped h);
    boolean eliminar(Long id);
}
