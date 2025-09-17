package com.tcg.habitaciones.controller;


import org.springframework.web.bind.annotation.*;

import com.tcg.commons.controller.CommonController;
import com.tcg.commons.dto.HabitacionRequest;
import com.tcg.commons.dto.HabitacionResponse;
import com.tcg.habitaciones.service.HabitacionService;

@RestController
public class HabitacionController extends CommonController<HabitacionRequest, HabitacionResponse, HabitacionService> {

    private final HabitacionService service;

    public HabitacionController(HabitacionService service) {
        this.service = service;
    }

    @Override
    protected HabitacionService getService() {
        return service;
    }
}
