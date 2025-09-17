package com.ruben.apigateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        // Para este entregable: todo permitido (JWT se puede activar después)
        http.csrf(ServerHttpSecurity.CsrfSpec::disable)
            .authorizeExchange(registry -> registry
                .pathMatchers("/actuator/**").permitAll()
                .anyExchange().permitAll()
            );
        return http.build();
    }
}
