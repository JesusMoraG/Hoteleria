package com.tcg.huespedes.impl;



import com.tcg.huespedes.dto.HuespedRequest;
import com.tcg.huespedes.dto.HuespedResponse;
import com.tcg.huespedes.mapper.HuespedMapper;
import com.tcg.huespedes.model.Huesped;
import com.tcg.huespedes.repository.HuespedRepository;
import com.tcg.huespedes.service.HuespedService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public List<HuespedResponse> findAll() {
        return repository.findAll().stream().map(mapper::toResponse).toList();
    }

    @Override
    public Optional<HuespedResponse> findById(Long id) {
        return repository.findById(id).map(mapper::toResponse);
    }

    @Override
    public Optional<HuespedResponse> findByEmail(String email) {
        return repository.findByEmail(email).map(mapper::toResponse);
    }

    @Override
    public HuespedResponse create(HuespedRequest request) {
        if (repository.existsByEmail(request.getEmail())) {
            throw new DataIntegrityViolationException("Email ya registrado");
        }
        if (repository.existsByTelefono(request.getTelefono())) {
            throw new DataIntegrityViolationException("Teléfono ya registrado");
        }
        Huesped entity = mapper.toEntity(request);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public HuespedResponse update(Long id, HuespedRequest request) {
        Huesped entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Huesped no encontrado"));

        if (!entity.getEmail().equals(request.getEmail()) && repository.existsByEmail(request.getEmail())) {
            throw new DataIntegrityViolationException("Email ya registrado");
        }
        if (!entity.getTelefono().equals(request.getTelefono()) && repository.existsByTelefono(request.getTelefono())) {
            throw new DataIntegrityViolationException("Teléfono ya registrado");
        }

        mapper.updateEntity(entity, request);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Huesped no encontrado");
        }
        repository.deleteById(id);
    }
}
