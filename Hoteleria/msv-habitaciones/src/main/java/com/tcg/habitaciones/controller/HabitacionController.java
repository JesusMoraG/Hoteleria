package com.tcg.habitaciones.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.tcg.commons.dto.HabitacionRequest;
import com.tcg.commons.dto.HabitacionResponse;
import com.tcg.habitaciones.service.HabitacionService;

@RestController
@RequestMapping("/api/habitaciones")
public class HabitacionController {

    private final HabitacionService service;

    public HabitacionController(HabitacionService service) {
        this.service = service;
    }

    @GetMapping
    public List<HabitacionResponse> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public HabitacionResponse obtener(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }

    @PostMapping
    public HabitacionResponse insertar(@RequestBody HabitacionRequest request) {
        return service.insertar(request);
    }

    @PutMapping("/{id}")
    public HabitacionResponse actualizar(@PathVariable Long id, @RequestBody HabitacionRequest request) {
        return service.actualizar(id, request);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
