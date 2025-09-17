package com.tcg.commons.clients;

import com.tcg.commons.config.FeingClientConfig;
import com.tcg.commons.dto.RolResponse;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-roles", configuration = FeingClientConfig.class)
public interface RolClient {

    @GetMapping("/api/roles/{id}")
    RolResponse obtenerPorId(@PathVariable Long id);

    @GetMapping("/api/roles/name/{nombre}")
    RolResponse obtenerPorNombre(@PathVariable("nombre") String nombre);
}
