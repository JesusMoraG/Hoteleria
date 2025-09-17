package com.tcg.huespedes.controller;


import org.springframework.web.bind.annotation.*;

import com.tcg.commons.controller.CommonController;
import com.tcg.commons.dto.HuespedRequest;
import com.tcg.commons.dto.HuespedResponse;
import com.tcg.huespedes.service.HuespedService;

@RestController
public class HuespedController extends CommonController<HuespedRequest, HuespedResponse, HuespedService> {

    private final HuespedService service;

    public HuespedController(HuespedService service) {
        this.service = service;
    }

    @Override
    protected HuespedService getService() {
        return service;
    }
}
