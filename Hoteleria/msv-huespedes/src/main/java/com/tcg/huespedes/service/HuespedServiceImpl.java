package com.tcg.huespedes.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tcg.commons.dto.HuespedRequest;
import com.tcg.commons.dto.HuespedResponse;
import com.tcg.commons.exceptions.ResourceNotFoundException;
import com.tcg.huespedes.mapper.HuespedMapper;
import com.tcg.huespedes.model.Huesped;
import com.tcg.huespedes.repository.HuespedRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class HuespedServiceImpl implements HuespedService {

    private final HuespedRepository repository;
    private final HuespedMapper mapper;

    public HuespedServiceImpl(HuespedRepository repository, HuespedMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<HuespedResponse> listarTodos() {
        return repository.findAll().stream()
                .map(mapper::entityToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public HuespedResponse obtenerPorId(Long id) {
        Huesped h = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Huésped no encontrado con id: " + id));
        return mapper.entityToResponse(h);
    }

    @Override
    public HuespedResponse insertar(HuespedRequest dto) {
        if (repository.existsByDocumento(dto.documento())) {
            throw new IllegalArgumentException("El documento ya está registrado");
        }
        if (repository.existsByEmail(dto.email())) {
            throw new IllegalArgumentException("El email ya está registrado");
        }

        Huesped entity = mapper.requestToEntity(dto);
        return mapper.entityToResponse(repository.save(entity));
    }


    @Override
    public HuespedResponse actualizar(Long id, HuespedRequest dto) {
        Huesped existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Huésped no encontrado con id: " + id));

        existing.setNombre(dto.nombre().trim());
        existing.setApellido(dto.apellido().trim());
        existing.setDocumento(dto.documento().trim());
        existing.setEmail(dto.email().trim());
        existing.setTelefono(dto.telefono().trim());
        existing.setNacionalidad(dto.nacionalidad().trim());

        return mapper.entityToResponse(repository.save(existing));
    }

    @Override
    public void eliminar(Long id) {
        Huesped existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Huésped no encontrado con id: " + id));
        repository.delete(existing);
    }
}
