package com.ruben.huespedes.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

// Ajustar 'msv-reservas' si el equipo usa otro nombre
@FeignClient(name = "msv-reservas", path = "/api/reservas")
public interface ReservasClient {

    @GetMapping("/ping")
    String ping();
}
