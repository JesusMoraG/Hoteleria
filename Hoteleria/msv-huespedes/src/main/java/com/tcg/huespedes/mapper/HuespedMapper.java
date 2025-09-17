package com.tcg.huespedes.mapper;


import org.springframework.stereotype.Component;

import com.tcg.commons.dto.HuespedRequest;
import com.tcg.commons.dto.HuespedResponse;
import com.tcg.commons.mapper.CommonMapper;
import com.tcg.huespedes.model.Huesped;

@Component
public class HuespedMapper extends CommonMapper<HuespedRequest, HuespedResponse, Huesped> {

    @Override
    public Huesped requestToEntity(HuespedRequest request) {
        Huesped huesped = new Huesped();
        huesped.setNombre(request.nombre().trim());
        huesped.setApellido(request.apellido().trim());
        huesped.setDocumento(request.documento().trim());
        huesped.setEmail(request.email().trim());
        huesped.setTelefono(request.telefono().trim());
        huesped.setNacionalidad(request.nacionalidad().trim());
        return huesped;
    }

    @Override
    public HuespedResponse entityToResponse(Huesped entity) {
        return new HuespedResponse(
            entity.getId(),
            entity.getNombre(),
            entity.getApellido(),
            entity.getDocumento(),
            entity.getEmail(),
            entity.getTelefono(),
            entity.getNacionalidad()
        );
    }
}
