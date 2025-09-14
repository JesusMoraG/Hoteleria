package com.tcg.commons.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tcg.commons.service.CommonService;

import jakarta.validation.Valid;
import java.util.List;

public abstract class CommonController<RQ, RS, S extends CommonService<RQ, RS>> {

    protected abstract S getService();

    @GetMapping
    public ResponseEntity<List<RS>> listarTodos() {
        return ResponseEntity.ok(getService().listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RS> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(getService().obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<RS> insertar(@Valid @RequestBody RQ dto) {
        return ResponseEntity.ok(getService().insertar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RS> actualizar(@PathVariable Long id, @Valid @RequestBody RQ dto) {
        return ResponseEntity.ok(getService().actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        getService().eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
