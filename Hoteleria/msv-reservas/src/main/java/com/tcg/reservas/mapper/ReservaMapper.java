package com.tcg.reservas.mapper;

import org.springframework.stereotype.Component;

import com.tcg.commons.dto.ReservaRequest;
import com.tcg.commons.dto.ReservaResponse;
import com.tcg.commons.mapper.CommonMapper;
import com.tcg.reservas.model.Reserva;

@Component
public class ReservaMapper extends CommonMapper<ReservaRequest, ReservaResponse, Reserva> {

    @Override
    public Reserva requestToEntity(ReservaRequest request) {
        Reserva reserva = new Reserva();
        reserva.setHuespedId(request.huespedId());
        reserva.setHabitacionId(request.habitacionId());
        reserva.setFechaEntrada(request.fechaEntrada());
        reserva.setFechaSalida(request.fechaSalida());
        reserva.setEstado(request.estado()); 
        return reserva;
    }

    @Override
    public ReservaResponse entityToResponse(Reserva entity) {
    	return new ReservaResponse(
    		    entity.getId(),
    		    entity.getHuespedId(),
    		    entity.getHabitacionId(),
    		    entity.getFechaEntrada(),
    		    entity.getFechaSalida(),
    		    entity.getEstado()
    		);
    }
}
