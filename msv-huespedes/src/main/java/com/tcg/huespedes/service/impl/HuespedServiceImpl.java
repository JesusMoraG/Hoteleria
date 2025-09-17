package com.tcg.huespedes.service.impl;

import com.tcg.huespedes.dto.HuespedDto;
import com.tcg.huespedes.mapper.HuespedMapper;
import com.tcg.huespedes.model.Huesped;
import com.tcg.huespedes.repository.HuespedRepository;
import com.tcg.huespedes.service.HuespedService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class HuespedServiceImpl implements HuespedService {

    private final HuespedRepository repo;

    public HuespedServiceImpl(HuespedRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<HuespedDto> findAll() {
        return repo.findAll().stream().map(HuespedMapper::toDto).toList();
    }

    @Override
    public HuespedDto findById(Long id) {
        Huesped e = repo.findById(id).orElseThrow(() -> new NoSuchElementException("No existe el huésped " + id));
        return HuespedMapper.toDto(e);
    }

    @Override
    public HuespedDto create(HuespedDto dto) {
        Huesped e = HuespedMapper.toEntity(dto);
        e.setId(null);
        return HuespedMapper.toDto(repo.save(e));
    }

    @Override
    public HuespedDto update(Long id, HuespedDto dto) {
        Huesped e = repo.findById(id).orElseThrow(() -> new NoSuchElementException("No existe el huésped " + id));
        HuespedMapper.copy(dto, e);
        return HuespedMapper.toDto(repo.save(e));
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
