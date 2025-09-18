package com.tcg.huespedes.mapper;

import com.tcg.commons.dto.HuespedRequest;
import com.tcg.commons.dto.HuespedResponse;
import com.tcg.huespedes.model.Huesped;
import org.springframework.stereotype.Component;

@Component
public class HuespedMapper {

    public HuespedResponse entityToResponse(Huesped entity) {
        return new HuespedResponse(
                entity.getId(),
                entity.getNombre(),
                entity.getApellido(),
                entity.getNumeroDocumento(),
                entity.getTipoDocumento(),
                entity.getTelefono(),
                entity.getEmail(),
                entity.getNacionalidad()
        );
    }

    public Huesped requestToEntity(HuespedRequest request) {
        Huesped huesped = new Huesped();
        huesped.setNombre(request.nombre() != null ? request.nombre().trim() : null);
        huesped.setApellido(request.apellido() != null ? request.apellido().trim() : null);
        huesped.setNumeroDocumento(request.numeroDocumento() != null ? request.numeroDocumento().trim() : null);
        huesped.setTipoDocumento(request.tipoDocumento());
        huesped.setTelefono(request.telefono() != null ? request.telefono().trim() : null);
        huesped.setEmail(request.email() != null ? request.email().trim() : null);
        huesped.setNacionalidad(request.nacionalidad() != null ? request.nacionalidad().trim() : null); // agregado
        return huesped;
    }
}
