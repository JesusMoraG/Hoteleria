package com.tcg.huespedes.service;

import java.util.Map;

public interface ExternalService {
    Map<String, Object> usuarioPorId(Long id);
    Map<String, Object> rolPorId(Long id);
}
