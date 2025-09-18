package com.tcg.habitaciones.mapper;

import org.springframework.stereotype.Component;

import com.tcg.commons.dto.HabitacionRequest;
import com.tcg.commons.dto.HabitacionResponse;
import com.tcg.commons.mapper.CommonMapper;
import com.tcg.habitaciones.model.Habitacion;

@Component
public class HabitacionMapper extends CommonMapper<HabitacionRequest, HabitacionResponse, Habitacion> {

    @Override
    public Habitacion requestToEntity(HabitacionRequest request) {
        Habitacion habitacion = new Habitacion();
        habitacion.setNumero(request.numero());
        habitacion.setTipo(request.tipo().trim());
        habitacion.setDescripcion(request.descripcion().trim());
        habitacion.setPrecio(request.precio());
        habitacion.setCapacidad(request.capacidad());
        habitacion.setEstado(request.estado()); 
        return habitacion;
    }

    @Override
    public HabitacionResponse entityToResponse(Habitacion entity) {
        return new HabitacionResponse(
            entity.getId(),
            entity.getNumero(),
            entity.getTipo(),
            entity.getDescripcion(),
            entity.getPrecio(),
            entity.getCapacidad(),
            entity.getEstado()
        );
    }
}
