package com.tcg.huespedes.mapper;

import com.tcg.huespedes.dto.HuespedRequest;
import com.tcg.huespedes.dto.HuespedResponse;
import com.tcg.huespedes.model.Huesped;
import org.springframework.stereotype.Component;

@Component
public class HuespedMapper {

    public HuespedResponse toResponse(Huesped e) {
        if (e == null) return null;
        return new HuespedResponse(
                e.getId(),
                e.getNombre(),
                e.getApellido(),
                e.getEmail(),
                e.getTelefono(),
                e.getDocumento(),
                e.getNacionalidad()
        );
    }

    public Huesped toEntity(HuespedRequest r) {
        if (r == null) return null;
        Huesped e = new Huesped();
        e.setNombre(r.getNombre());
        e.setApellido(r.getApellido());
        e.setEmail(r.getEmail());
        e.setTelefono(r.getTelefono());
        e.setDocumento(r.getDocumento());
        e.setNacionalidad(r.getNacionalidad());
        return e;
    }

    public void updateEntity(Huesped e, HuespedRequest r) {
        if (e == null || r == null) return;
        e.setNombre(r.getNombre());
        e.setApellido(r.getApellido());
        e.setEmail(r.getEmail());
        e.setTelefono(r.getTelefono());
        e.setDocumento(r.getDocumento());
        e.setNacionalidad(r.getNacionalidad());
    }
}
