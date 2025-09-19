package com.tcg.reservas.service;

import com.tcg.commons.clients.HabitacionClient;
import com.tcg.commons.clients.HuespedClient;
import com.tcg.commons.dto.HabitacionResponse;
import com.tcg.commons.dto.HuespedResponse;
import com.tcg.commons.dto.ReservaRequest;
import com.tcg.commons.dto.ReservaResponse;
import com.tcg.commons.exceptions.ResourceNotFoundException;
import com.tcg.reservas.mapper.ReservaMapper;
import com.tcg.reservas.model.Reserva;
import com.tcg.reservas.repository.ReservaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@Transactional
public class ReservaServiceImpl implements ReservaService {

	private final ReservaRepository repository;
    private final ReservaMapper mapper;
    private final HuespedClient huespedClient;
    private final HabitacionClient habitacionClient;

    public ReservaServiceImpl(ReservaRepository repository,
                              ReservaMapper mapper,
                              HuespedClient huespedClient,
                              HabitacionClient habitacionClient) {
        this.repository = repository;
        this.mapper = mapper;
        this.huespedClient = huespedClient;
        this.habitacionClient = habitacionClient;
}

    @Override
    public List<ReservaResponse> listarTodos() {
        return repository.findAll()
                .stream()
                .map(mapper::entityToResponse)
                .toList();
    }

    @Override
    public ReservaResponse obtenerPorId(Long id) {
        Reserva reserva = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reserva no encontrada con id: " + id));
        return mapper.entityToResponse(reserva);
    }

    @Override
    public ReservaResponse insertar(ReservaRequest dto) {
        Reserva entity = mapper.requestToEntity(dto);
        return mapper.entityToResponse(repository.save(entity));
    }

    @Override
    public ReservaResponse actualizar(Long id, ReservaRequest dto) {
        Reserva existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reserva no encontrada con id: " + id));

        existing.setHuespedId(dto.huespedId());
        existing.setHabitacionId(dto.habitacionId());
        existing.setFechaEntrada(dto.fechaEntrada());
        existing.setFechaSalida(dto.fechaSalida());
        existing.setEstado(dto.estado());

        return mapper.entityToResponse(repository.save(existing));
    }

    @Override
    public void eliminar(Long id) {
        Reserva existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reserva no encontrada con id: " + id));
        repository.delete(existing);
    }
    
    private ReservaResponse convertirAResponse(Reserva reserva) {
        HuespedResponse huesped = huespedClient.obtenerPorId(reserva.getHuespedId());
        HabitacionResponse habitacion = habitacionClient.obtenerPorId(reserva.getHabitacionId());

        int noches = (int) ChronoUnit.DAYS.between(reserva.getFechaEntrada(), reserva.getFechaSalida());
        BigDecimal total = habitacion.precio().multiply(BigDecimal.valueOf(noches));

        return new ReservaResponse(
                reserva.getId(),
                huesped.nombre(),
                huesped.apellido(),
                reserva.getFechaEntrada(),
                reserva.getFechaSalida(),
                noches,
                total,
                reserva.getEstado()
        );
    }
}
