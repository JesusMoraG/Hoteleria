package com.tcg.roles.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tcg.commons.dto.RolRequest;
import com.tcg.commons.dto.RolResponse;
import com.tcg.commons.exceptions.ResourceNotFoundException;
import com.tcg.roles.mapper.RolMapper;
import com.tcg.roles.model.Rol;
import com.tcg.roles.repository.RolRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RolServiceImpl implements RolService {

    private final RolRepository repository;
    private final RolMapper mapper;

    public RolServiceImpl(RolRepository repository, RolMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<RolResponse> listarTodos() {
        return repository.findAll()
                .stream()
                .map(mapper::entityToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public RolResponse obtenerPorId(Long id) {
        Rol rol = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rol no encontrado con id: " + id));
        return mapper.entityToResponse(rol);
    }

    @Override
    public RolResponse insertar(RolRequest dto) {
        if (repository.existsByNombre(dto.nombre())) {
            throw new IllegalArgumentException("El rol ya existe");
        }
        Rol entity = mapper.requestToEntity(dto);
        return mapper.entityToResponse(repository.save(entity));
    }

    @Override
    public RolResponse actualizar(Long id, RolRequest dto) {
        Rol existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rol no encontrado con id: " + id));
        existing.setNombre(dto.nombre().trim());
        return mapper.entityToResponse(repository.save(existing));
    }

    @Override
    public void eliminar(Long id) {
        Rol existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rol no encontrado con id: " + id));
        repository.delete(existing);
    }
}
