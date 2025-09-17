package com.tcg.huespedes.service;

import com.tcg.huespedes.dto.HuespedDto;
import java.util.List;

public interface HuespedService {
    List<HuespedDto> findAll();
    HuespedDto findById(Long id);
    HuespedDto create(HuespedDto dto);
    HuespedDto update(Long id, HuespedDto dto);
    void delete(Long id);
}
