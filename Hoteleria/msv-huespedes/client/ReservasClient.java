package com.tcg.huespedes.client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
@FeignClient(name = "msv-reservas", path = "/api/reservas")
public interface ReservasClient {
    @GetMapping("/ping")
    String ping();
}
