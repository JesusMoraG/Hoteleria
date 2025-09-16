package com.tcg.huespedes.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.tcg.huespedes.client.RolesClient;
import com.tcg.huespedes.client.UsuariosClient;
import com.tcg.huespedes.service.ExternalService;

@Service
public class ExternalServiceImpl implements ExternalService {

    private final UsuariosClient usuariosClient;
    private final RolesClient rolesClient;

    public ExternalServiceImpl(UsuariosClient usuariosClient, RolesClient rolesClient) {
        this.usuariosClient = usuariosClient;
        this.rolesClient = rolesClient;
    }

    @Override
    public Map<String, Object> usuarioPorId(Long id) {
        return usuariosClient.getById(id);
    }

    @Override
    public Map<String, Object> rolPorId(Long id) {
        return rolesClient.getById(id);
    }
}
