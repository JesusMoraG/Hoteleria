package com.tcg.habitaciones.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import com.tcg.commons.dto.HabitacionRequest;
import com.tcg.commons.dto.HabitacionResponse;
import com.tcg.commons.dto.RolResponse;
import com.tcg.habitaciones.mapper.HabitacionMapper;
import com.tcg.habitaciones.model.Habitacion;
import com.tcg.habitaciones.repository.HabitacionRepository;

@Service
@Transactional
public class HabitacionServiceImpl implements HabitacionService {

    private final HabitacionRepository repository;
    private final HabitacionMapper mapper;

    public HabitacionServiceImpl(HabitacionRepository repository, HabitacionMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<HabitacionResponse> listarTodos() {
        return repository.findAll()
                .stream()
                .map(mapper::entityToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public HabitacionResponse obtenerPorId(Long id) {
        Habitacion habitacion = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Habitación no encontrada con id: " + id));
        return mapper.entityToResponse(habitacion);
    }

    @Override
    public HabitacionResponse insertar(HabitacionRequest request) {
        Habitacion entity = mapper.requestToEntity(request);
        return mapper.entityToResponse(repository.save(entity));
    }

    @Override
    public HabitacionResponse actualizar(Long id, HabitacionRequest request) {
        Habitacion existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Habitación no encontrada con id: " + id));

        existing.setNumero(request.numero());
        existing.setTipo(request.tipo());
        existing.setDescripcion(request.descripcion());
        existing.setPrecio(request.precio());
        existing.setCapacidad(request.capacidad());
        existing.setEstado(request.estado());

        return mapper.entityToResponse(repository.save(existing));
    }

    @Override
    public void eliminar(Long id) {
        Habitacion existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Habitación no encontrada con id: " + id));
        repository.delete(existing);
    }
}
