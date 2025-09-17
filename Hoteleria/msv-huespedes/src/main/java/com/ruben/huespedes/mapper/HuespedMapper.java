package com.ruben.huespedes.mapper;

import com.ruben.huespedes.dto.HuespedRequest;
import com.ruben.huespedes.dto.HuespedResponse;
import com.ruben.huespedes.model.Huesped;
import org.springframework.stereotype.Component;

@Component
public class HuespedMapper {

    public Huesped toEntity(HuespedRequest req) {
        Huesped h = new Huesped();
        h.setNombre(req.getNombre());
        h.setEmail(req.getEmail());
        h.setTelefono(req.getTelefono());
        return h;
    }

    public void updateEntity(Huesped entity, HuespedRequest req) {
        entity.setNombre(req.getNombre());
        entity.setEmail(req.getEmail());
        entity.setTelefono(req.getTelefono());
    }

    public HuespedResponse toResponse(Huesped entity) {
        return new HuespedResponse(entity.getId(), entity.getNombre(), entity.getEmail(), entity.getTelefono());
    }
}
