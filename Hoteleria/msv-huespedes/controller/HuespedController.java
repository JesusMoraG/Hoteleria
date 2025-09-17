package com.tcg.huespedes.controller;
import com.tcg.huespedes.model.Huesped;
import com.tcg.huespedes.service.HuespedService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/huespedes")
public class HuespedController {
    private final HuespedService service;
    public HuespedController(HuespedService service) { this.service = service; }
    @GetMapping public List<Huesped> listar() { return service.listar(); }
    @GetMapping("/{id}") public ResponseEntity<Huesped> obtener(@PathVariable Long id) { return service.buscar(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build()); }
    @PostMapping public Huesped crear(@RequestBody Huesped h) { return service.crear(h); }
    @PutMapping("/{id}") public ResponseEntity<Huesped> editar(@PathVariable Long id, @RequestBody Huesped h) { return service.editar(id, h).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build()); }
    @DeleteMapping("/{id}") public ResponseEntity<Void> eliminar(@PathVariable Long id) { return service.eliminar(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build(); }
}
