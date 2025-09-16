package com.tcg.habitaciones.mapper;

import org.springframework.stereotype.Component;

import com.tcg.commons.dto.HabitacionResponse;
import com.tcg.commons.mapper.CommonMapper;
import com.tcg.habitaciones.model.Habitacion;
import  com.tcg.commons.dto.HabitacionRequest;

@Component
public class HabitacionMapper extends CommonMapper<HabitacionRequest, HabitacionResponse, Habitacion>{

	@Override
	public HabitacionResponse entityToResponse(Habitacion entity) {
		if(entity==null) {
			return null;
		}
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

	@Override
	public Habitacion requestToEntity(HabitacionRequest request) {
	    if (request == null) {
	        return null;
	    }

	    Habitacion habitacion = new Habitacion();
	    habitacion.setNumero(request.numero());
	    habitacion.setTipo(request.tipo());
	    habitacion.setDescripcion(request.descripcion());
	    habitacion.setPrecio(request.precio());
	    habitacion.setCapacidad(request.capacidad());
	    habitacion.setEstado(request.estado());

	    return habitacion;
	}
}
