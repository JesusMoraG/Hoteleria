package com.tcg.huespedes.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.tcg.huespedes.models.Huesped;

public class HuespedMapper {

    public static Huesped toEntity(HuespedRequest r) {
        Huesped h = new Huesped();
        h.setNombre(r.getNombre());
        h.setApellido(r.getApellido());
        h.setEmail(r.getEmail());
        h.setTelefono(r.getTelefono());
        h.setDocumento(r.getDocumento());
        h.setNacionalidad(r.getNacionalidad());
        return h;
    }

    public static void updateEntity(Huesped h, HuespedRequest r) {
        h.setNombre(r.getNombre());
        h.setApellido(r.getApellido());
        h.setEmail(r.getEmail());
        h.setTelefono(r.getTelefono());
        h.setDocumento(r.getDocumento());
        h.setNacionalidad(r.getNacionalidad());
    }

    public static HuespedResponse toResponse(Huesped h) {
        HuespedResponse dto = new HuespedResponse();
        dto.setId(h.getId());
        dto.setNombre(h.getNombre());
        dto.setApellido(h.getApellido());
        dto.setEmail(h.getEmail());
        dto.setTelefono(h.getTelefono());
        dto.setDocumento(h.getDocumento());
        dto.setNacionalidad(h.getNacionalidad());
        return dto;
    }

    public static List<HuespedResponse> toResponseList(List<Huesped> list) {
        return list.stream().map(HuespedMapper::toResponse).collect(Collectors.toList());
    }
}
