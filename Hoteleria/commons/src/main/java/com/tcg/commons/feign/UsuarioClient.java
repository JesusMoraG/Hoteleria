package com.tcg.commons.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.tcg.commons.dto.UsuarioResponse;

@FeignClient(name = "ms-usuarios", path = "/api/usuarios")
public interface UsuarioClient {

    @GetMapping("/{id}")
    UsuarioResponse obtenerPorId(@PathVariable Long id);

   
    @GetMapping("/search/by-username")
    UsuarioResponse buscarPorUsername(@RequestParam("username") String username);
}
