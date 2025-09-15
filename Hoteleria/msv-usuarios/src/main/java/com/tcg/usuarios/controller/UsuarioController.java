package com.tcg.usuarios.controller;

import org.springframework.web.bind.annotation.*;

import com.tcg.commons.controller.CommonController;
import com.tcg.commons.dto.UsuarioRequest;
import com.tcg.commons.dto.UsuarioResponse;
import com.tcg.usuarios.service.UsuarioService;

@RestController
public class UsuarioController extends CommonController<UsuarioRequest, UsuarioResponse, UsuarioService> {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @Override
    protected UsuarioService getService() {
        return service;
    }
}
