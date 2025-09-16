package com.tcg.huespedes.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.tcg.huespedes.models.Huesped;
import com.tcg.huespedes.service.HuespedService;

import jakarta.validation.Valid;

@RestController
@RequestMapping
@Validated
public class HuespedController {

    private final HuespedService service;

    public HuespedController(HuespedService service) {
        this.service = service;
    }

    @GetMapping("/")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity<List<Huesped>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity<Huesped> ver(@PathVariable Long id) {
        Optional<Huesped> h = service.buscarPorId(id);
        return h.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity<Huesped> crear(@Valid @RequestBody Huesped h) {
        Huesped creado = service.crear(h);
        return ResponseEntity.created(URI.create("/" + creado.getId())).body(creado);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Huesped> actualizar(@PathVariable Long id, @Valid @RequestBody Huesped h) {
        Huesped actualizado = service.actualizar(id, h);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
