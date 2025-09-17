package com.ruben.huespedes.service.impl;

import com.ruben.huespedes.dto.HuespedRequest;
import com.ruben.huespedes.dto.HuespedResponse;
import com.ruben.huespedes.mapper.HuespedMapper;
import com.ruben.huespedes.model.Huesped;
import com.ruben.huespedes.repository.HuespedRepository;
import com.ruben.huespedes.service.HuespedService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
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
    @Transactional(readOnly = true)
    public List<HuespedResponse> listar() {
        return repository.findAll().stream().map(mapper::toResponse).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<HuespedResponse> buscar(Long id) {
        return repository.findById(id).map(mapper::toResponse);
    }

    @Override
    public HuespedResponse crear(HuespedRequest request) {
        if (repository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("El email ya existe");
        }
        Huesped entity = mapper.toEntity(request);
        entity = repository.save(entity);
        return mapper.toResponse(entity);
    }

    @Override
    public Optional<HuespedResponse> editar(Long id, HuespedRequest request) {
        return repository.findById(id).map(entity -> {
            if (!entity.getEmail().equals(request.getEmail()) && repository.existsByEmail(request.getEmail())) {
                throw new IllegalArgumentException("El email ya existe");
            }
            mapper.updateEntity(entity, request);
            return mapper.toResponse(entity);
        });
    }

    @Override
    public boolean eliminar(Long id) {
        return repository.findById(id).map(entity -> { repository.delete(entity); return true; }).orElse(false);
    }
}
