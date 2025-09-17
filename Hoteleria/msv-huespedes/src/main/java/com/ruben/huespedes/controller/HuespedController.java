package com.ruben.huespedes.controller;

import com.ruben.huespedes.dto.HuespedRequest;
import com.ruben.huespedes.dto.HuespedResponse;
import com.ruben.huespedes.service.HuespedService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/huespedes")
public class HuespedController {

    private final HuespedService service;

    public HuespedController(HuespedService service) {
        this.service = service;
    }

    @GetMapping
    public List<HuespedResponse> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HuespedResponse> obtener(@PathVariable Long id) {
        return service.buscar(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<HuespedResponse> crear(@Valid @RequestBody HuespedRequest request) {
        HuespedResponse resp = service.crear(request);
        return ResponseEntity.created(URI.create("/api/huespedes/" + resp.getId())).body(resp);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HuespedResponse> editar(@PathVariable Long id, @Valid @RequestBody HuespedRequest request) {
        return service.editar(id, request).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        return service.eliminar(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
