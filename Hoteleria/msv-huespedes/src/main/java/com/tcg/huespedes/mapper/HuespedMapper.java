package com.tcg.huespedes.mapper;

import com.tcg.huespedes.dto.HuespedDto;
import com.tcg.huespedes.model.Huesped;

public class HuespedMapper {

    public static HuespedDto toDto(Huesped e) {
        if (e == null) return null;
        HuespedDto d = new HuespedDto();
        d.setId(e.getId());
        d.setNombre(e.getNombre());
        d.setApellido(e.getApellido());
        d.setEmail(e.getEmail());
        d.setTelefono(e.getTelefono());
        return d;
    }

    public static Huesped toEntity(HuespedDto d) {
        if (d == null) return null;
        Huesped e = new Huesped();
        e.setId(d.getId());
        e.setNombre(d.getNombre());
        e.setApellido(d.getApellido());
        e.setEmail(d.getEmail());
        e.setTelefono(d.getTelefono());
        return e;
    }

    public static void copy(HuespedDto d, Huesped e) {
        e.setNombre(d.getNombre());
        e.setApellido(d.getApellido());
        e.setEmail(d.getEmail());
        e.setTelefono(d.getTelefono());
    }
}
