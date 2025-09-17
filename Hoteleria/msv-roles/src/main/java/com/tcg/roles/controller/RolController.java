package com.tcg.roles.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tcg.commons.controller.CommonController;
import com.tcg.commons.dto.RolRequest;
import com.tcg.commons.dto.RolResponse;
import com.tcg.roles.service.RolService;

@RestController
public class RolController extends CommonController<RolRequest, RolResponse, RolService> {

    private final RolService service;

    public RolController(RolService service) {
        this.service = service;
    }

    @Override
    protected RolService getService() {
        return service;
    }
    
 
    public ResponseEntity<RolResponse> buscarPorNombre(@PathVariable String nombre) {
        return ResponseEntity.ok(service.buscarPorNombre(nombre));
    }

}
