package com.tcg.commons.clients;

import com.tcg.commons.config.FeingClientConfig;
import com.tcg.commons.dto.HabitacionResponse;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
    name = "ms-habitaciones",
    configuration = FeingClientConfig.class
)
public interface HabitacionClient {

    @GetMapping("/api/habitaciones/{id}")
    HabitacionResponse obtenerPorId(@PathVariable Long id);
}
