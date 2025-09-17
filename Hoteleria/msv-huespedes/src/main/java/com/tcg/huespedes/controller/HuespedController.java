package com.tcg.huespedes.controller;

import com.tcg.huespedes.dto.HuespedRequest;
import com.tcg.huespedes.dto.HuespedResponse;
import com.tcg.huespedes.service.HuespedService;
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
    public List<HuespedResponse> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HuespedResponse> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public ResponseEntity<HuespedResponse> findByEmail(@RequestParam String email) {
        return service.findByEmail(email)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<HuespedResponse> create(@Valid @RequestBody HuespedRequest request) {
        HuespedResponse created = service.create(request);
        return ResponseEntity.created(URI.create("/api/huespedes/" + created.id())).body(created);

    }

    @PutMapping("/{id}")
    public ResponseEntity<HuespedResponse> update(@PathVariable Long id,
                                                  @Valid @RequestBody HuespedRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
