package com.tcg.commons.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tcg.commons.dto.RolResponse;

@FeignClient(name = "msv-roles", path = "/api/roles")
public interface RolClient {

    @GetMapping("/{id}")
    RolResponse obtenerPorId(@PathVariable Long id);
}
