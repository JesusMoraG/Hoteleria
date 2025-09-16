package com.tcg.usuarios.mapper;


import org.springframework.stereotype.Component;

import com.tcg.commons.dto.UsuarioRequest;
import com.tcg.commons.dto.UsuarioResponse;
import com.tcg.commons.mapper.CommonMapper;
import com.tcg.usuarios.model.Usuario;

@Component
public class UsuarioMapper extends CommonMapper<UsuarioRequest, UsuarioResponse, Usuario> {

    @Override
    public Usuario requestToEntity(UsuarioRequest request) {
        Usuario usuario = new Usuario();
        usuario.setUsername(request.username().trim());
        usuario.setPassword(request.password().trim());
        usuario.setRol(request.rol());
        return usuario;
    }

    @Override
    public UsuarioResponse entityToResponse(Usuario entity) {
        return new UsuarioResponse(entity.getId(), entity.getUsername(), entity.getRol());
    }
}
