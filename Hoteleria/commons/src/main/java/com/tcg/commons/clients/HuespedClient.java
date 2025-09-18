package com.tcg.commons.clients;

import com.tcg.commons.dto.HuespedResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "msv-huespedes", url = "http://localhost:8081/api/huespedes")
public interface HuespedClient {

    @GetMapping("/{id}")
    HuespedResponse obtenerPorId(@PathVariable Long id);
}
