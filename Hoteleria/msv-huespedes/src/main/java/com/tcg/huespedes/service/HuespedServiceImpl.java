package com.tcg.huespedes.service;

import com.tcg.commons.dto.HuespedRequest;
import com.tcg.commons.dto.HuespedResponse;
import com.tcg.commons.exceptions.ResourceNotFoundException;
import com.tcg.huespedes.mapper.HuespedMapper;
import com.tcg.huespedes.model.Huesped;
import com.tcg.huespedes.repository.HuespedRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        return repository.findAll()
                .stream()
                .map(mapper::entityToResponse)
                .toList();
    }

    @Override
    public HuespedResponse obtenerPorId(Long id) {
        Huesped huesped = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Huésped no encontrado con id: " + id));
        return mapper.entityToResponse(huesped);
    }

    @Override
    public HuespedResponse insertar(HuespedRequest dto) {
        if (repository.existsByNumeroDocumento(dto.numeroDocumento())) {
            throw new IllegalArgumentException("El número de documento ya existe");
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
        existing.setNumeroDocumento(dto.numeroDocumento().trim());
        existing.setTipoDocumento(dto.tipoDocumento());
        existing.setTelefono(dto.telefono() != null ? dto.telefono().trim() : null);
        existing.setEmail(dto.email() != null ? dto.email().trim() : null);

        return mapper.entityToResponse(repository.save(existing));
    }

    @Override
    public void eliminar(Long id) {
        Huesped existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Huésped no encontrado con id: " + id));
        repository.delete(existing);
    }
}
