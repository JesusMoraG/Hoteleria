package com.tcg.habitaciones.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tcg.commons.dto.HabitacionRequest;
import com.tcg.commons.dto.HabitacionResponse;
import com.tcg.commons.exceptions.ResourceNotFoundException;
import com.tcg.habitaciones.mapper.HabitacionMapper;
import com.tcg.habitaciones.model.Habitacion;
import com.tcg.habitaciones.repository.HabitacionRepository;

import java.util.List;
import java.util.stream.Collectors;

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
                .toList();
    }

    @Override
    public HabitacionResponse obtenerPorId(Long id) {
        Habitacion habitacion = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Habitación no encontrada con id: " + id));
        return mapper.entityToResponse(habitacion);
    }

    @Override
    public HabitacionResponse insertar(HabitacionRequest dto) {
        if (repository.existsByNumero(dto.numero())) {
            throw new IllegalArgumentException("El número de habitación ya existe");
        }
        Habitacion entity = mapper.requestToEntity(dto);
        return mapper.entityToResponse(repository.save(entity));
    }

    @Override
    public HabitacionResponse actualizar(Long id, HabitacionRequest dto) {
        Habitacion existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Habitación no encontrada con id: " + id));

        existing.setNumero(dto.numero());
        existing.setTipo(dto.tipo().trim());
        existing.setDescripcion(dto.descripcion().trim());
        existing.setPrecio(dto.precio());
        existing.setCapacidad(dto.capacidad());
        existing.setEstado(dto.estado().trim());

        return mapper.entityToResponse(repository.save(existing));
    }

    @Override
    public void eliminar(Long id) {
        Habitacion existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Habitación no encontrada con id: " + id));
        repository.delete(existing);
    }
}
