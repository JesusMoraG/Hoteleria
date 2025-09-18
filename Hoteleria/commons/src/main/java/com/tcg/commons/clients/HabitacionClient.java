package com.tcg.commons.clients;

import com.tcg.commons.dto.HabitacionResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "msv-habitaciones", url = "http://localhost:8082/api/habitaciones")
public interface HabitacionClient {

    @GetMapping("/{id}")
    HabitacionResponse obtenerPorId(@PathVariable Long id);
}
