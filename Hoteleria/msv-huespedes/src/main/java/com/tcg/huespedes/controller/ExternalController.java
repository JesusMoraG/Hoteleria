package com.tcg.huespedes.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.tcg.huespedes.service.ExternalService;

@RestController
@RequestMapping("/ext")
public class ExternalController {

  private final ExternalService external;

  public ExternalController(ExternalService external) {
    this.external = external;
  }

  @GetMapping("/usuario/{id}")
  @PreAuthorize("hasAnyRole('USER','ADMIN')")
  public ResponseEntity<Map<String,Object>> usuario(@PathVariable Long id) {
    return ResponseEntity.ok(external.usuarioPorId(id));
  }

  @GetMapping("/rol/{id}")
  @PreAuthorize("hasAnyRole('USER','ADMIN')")
  public ResponseEntity<Map<String,Object>> rol(@PathVariable Long id) {
    return ResponseEntity.ok(external.rolPorId(id));
  }
}
