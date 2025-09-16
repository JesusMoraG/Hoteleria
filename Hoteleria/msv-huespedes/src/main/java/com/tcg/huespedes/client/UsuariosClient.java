package com.tcg.huespedes.client;

import java.util.Map;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "msv-usuarios", path = "/api/usuarios")
public interface UsuariosClient {
    @GetMapping("/{id}")
    Map<String, Object> getById(@PathVariable("id") Long id);
}
