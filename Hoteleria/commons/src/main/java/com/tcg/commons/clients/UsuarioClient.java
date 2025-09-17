package com.tcg.commons.clients;

import com.tcg.commons.config.FeingClientConfig;
import com.tcg.commons.dto.UsuarioResponse;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
    name = "ms-usuarios",
    configuration = FeingClientConfig.class
)
public interface UsuarioClient {

    @GetMapping("/api/usuarios/{id}")
    UsuarioResponse obtenerPorId(@PathVariable Long id);

    @GetMapping("/api/usuarios/username/{username}")
    UsuarioResponse obtenerPorUsername(@PathVariable String username);
}
