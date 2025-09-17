package com.tcg.huespedes.service;

import com.tcg.huespedes.dto.HuespedRequest;
import com.tcg.huespedes.dto.HuespedResponse;

import java.util.List;
import java.util.Optional;

public interface HuespedService {
    List<HuespedResponse> findAll();
    Optional<HuespedResponse> findById(Long id);
    Optional<HuespedResponse> findByEmail(String email);
    HuespedResponse create(HuespedRequest request);
    HuespedResponse update(Long id, HuespedRequest request);
    void delete(Long id);
}
