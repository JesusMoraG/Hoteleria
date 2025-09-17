package com.tcg.commons.clients;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tcg.commons.config.FeingClientConfig;
import com.tcg.commons.dto.ReservaResponse;

@FeignClient(
    name = "ms-reservas",
    configuration = FeingClientConfig.class
)
public interface ReservaClient {

    @GetMapping("/api/reservas/{id}")
    ReservaResponse obtenerPorId(@PathVariable Long id);
}
