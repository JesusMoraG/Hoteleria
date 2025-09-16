package com.tcg.huespedes.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.tcg.huespedes.models.Huesped;
import com.tcg.huespedes.repository.HuespedRepository;
import com.tcg.huespedes.service.HuespedService;

@Service
@Transactional
public class HuespedServiceImpl implements HuespedService {

    private final HuespedRepository repo;

    public HuespedServiceImpl(HuespedRepository repo) {
        this.repo = repo;
    }

    @Override
    public Huesped crear(Huesped h) {
        if (repo.existsByEmail(h.getEmail())) throw new IllegalStateException("Email ya registrado");
        if (repo.existsByTelefono(h.getTelefono())) throw new IllegalStateException("Telefono ya registrado");
        return repo.save(h);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Huesped> listar() {
        return repo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Huesped> buscarPorId(Long id) {
        return repo.findById(id);
    }

    @Override
    public Huesped actualizar(Long id, Huesped h) {
        Huesped db = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("No existe"));
        if (!db.getEmail().equals(h.getEmail()) && repo.existsByEmail(h.getEmail()))
            throw new IllegalStateException("Email ya registrado");
        if (!db.getTelefono().equals(h.getTelefono()) && repo.existsByTelefono(h.getTelefono()))
            throw new IllegalStateException("Telefono ya registrado");
        db.setNombre(h.getNombre());
        db.setApellido(h.getApellido());
        db.setEmail(h.getEmail());
        db.setTelefono(h.getTelefono());
        db.setDocumento(h.getDocumento());
        db.setNacionalidad(h.getNacionalidad());
        return repo.save(db);
    }

    @Override
    public void eliminar(Long id) {
        if (!repo.existsById(id)) throw new IllegalArgumentException("No existe");
        repo.deleteById(id);
    }
}
