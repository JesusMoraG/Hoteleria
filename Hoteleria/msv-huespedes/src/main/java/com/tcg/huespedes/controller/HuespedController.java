package com.tcg.huespedes.controller;

import com.tcg.huespedes.dto.HuespedDto;
import com.tcg.huespedes.service.HuespedService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/huespedes")
public class HuespedController {

    private final HuespedService service;

    public HuespedController(HuespedService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<HuespedDto>> listar() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HuespedDto> ver(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<HuespedDto> crear(@Valid @RequestBody HuespedDto dto) {
        HuespedDto creado = service.create(dto);
        return ResponseEntity.created(URI.create("/huespedes/" + creado.getId())).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HuespedDto> editar(@PathVariable Long id, @Valid @RequestBody HuespedDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
