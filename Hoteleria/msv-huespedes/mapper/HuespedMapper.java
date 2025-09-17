package com.tcg.huespedes.mapper;
import com.tcg.huespedes.model.Huesped;
import org.springframework.stereotype.Component;
@Component
public class HuespedMapper {
    public void copy(Huesped src, Huesped dst) {
        dst.setNombre(src.getNombre());
        dst.setEmail(src.getEmail());
        dst.setTelefono(src.getTelefono());
    }
}
