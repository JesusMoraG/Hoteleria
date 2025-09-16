package com.tcg.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class SecurityConfig {

  @Bean
  SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
    http.csrf(csrf -> csrf.disable());
    http.authorizeExchange(ex -> ex
        .pathMatchers("/actuator/**", "/api/huespedes/ping").permitAll()
        .anyExchange().authenticated());
    http.oauth2ResourceServer(o -> o.jwt());
    return http.build();
  }
}
