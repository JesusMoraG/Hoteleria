package com.tcg.reservas.controller;

import org.springframework.web.bind.annotation.RestController;

import com.tcg.commons.controller.CommonController;
import com.tcg.commons.dto.ReservaRequest;
import com.tcg.commons.dto.ReservaResponse;
import com.tcg.reservas.service.ReservaService;

@RestController
public class ReservaController extends CommonController<ReservaRequest, ReservaResponse, ReservaService> {

    private final ReservaService service;

    public ReservaController(ReservaService service) {
        this.service = service;
    }

    @Override
    protected ReservaService getService() {
        return service;
    }
}
