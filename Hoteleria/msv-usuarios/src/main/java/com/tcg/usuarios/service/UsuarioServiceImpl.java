package com.tcg.usuarios.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tcg.commons.dto.UsuarioRequest;
import com.tcg.commons.dto.UsuarioResponse;
import com.tcg.commons.exceptions.ResourceNotFoundException;
import com.tcg.commons.feign.RolClient;
import com.tcg.usuarios.mapper.UsuarioMapper;
import com.tcg.usuarios.model.Usuario;
import com.tcg.usuarios.repository.UsuarioRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repository;
    private final UsuarioMapper mapper;
    private final RolClient rolClient;

    public UsuarioServiceImpl(UsuarioRepository repository, UsuarioMapper mapper, RolClient rolClient) {
        this.repository = repository;
        this.mapper = mapper;
        this.rolClient = rolClient;
    }

    @Override
    public List<UsuarioResponse> listarTodos() {
        return repository.findAll()
                .stream()
                .map(mapper::entityToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioResponse obtenerPorId(Long id) {
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con id: " + id));
        return mapper.entityToResponse(usuario);
    }

    @Override
    public UsuarioResponse insertar(UsuarioRequest dto) {
        if (repository.existsByUsername(dto.username())) {
            throw new IllegalArgumentException("El username ya existe");
        }

        
        Usuario entity = mapper.requestToEntity(dto);
        return mapper.entityToResponse(repository.save(entity));
    }

    @Override
    public UsuarioResponse actualizar(Long id, UsuarioRequest dto) {
    	 Usuario existing = repository.findById(id)
    	            .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con id: " + id));

        existing.setUsername(dto.username().trim());
        existing.setPassword(dto.password().trim());
        existing.setRol(dto.rol().trim());

        return mapper.entityToResponse(repository.save(existing));
    }

    @Override
    public void eliminar(Long id) {
        Usuario existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con id: " + id));
        repository.delete(existing);
    }
}
