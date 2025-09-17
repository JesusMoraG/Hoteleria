package com.tcg.commons.clients;

import com.tcg.commons.config.FeingClientConfig;
import com.tcg.commons.dto.HuespedResponse;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
    name = "ms-huespedes",
    configuration = FeingClientConfig.class
)
public interface HuespedClient {

    @GetMapping("/api/huespedes/{id}")
    HuespedResponse obtenerPorId(@PathVariable Long id);
}
