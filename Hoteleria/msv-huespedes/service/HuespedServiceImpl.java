package com.tcg.huespedes.service;
import com.tcg.huespedes.model.Huesped;
import com.tcg.huespedes.repository.HuespedRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class HuespedServiceImpl implements HuespedService {
    private final HuespedRepository repo;
    public HuespedServiceImpl(HuespedRepository repo) { this.repo = repo; }
    public List<Huesped> listar() { return repo.findAll(); }
    public Optional<Huesped> buscar(Long id) { return repo.findById(id); }
    public Huesped crear(Huesped h) { return repo.save(h); }
    public Optional<Huesped> editar(Long id, Huesped h) { return repo.findById(id).map(e -> { e.setNombre(h.getNombre()); e.setEmail(h.getEmail()); e.setTelefono(h.getTelefono()); return e; }); }
    public boolean eliminar(Long id) { return repo.findById(id).map(e -> { repo.delete(e); return true; }).orElse(false); }
}
