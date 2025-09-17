package com.tcg.huespedes.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "msv-roles", path = "/roles")
public interface RolesClient {
    @GetMapping("/{id}")
    String getRol(@PathVariable("id") Long id);
}
