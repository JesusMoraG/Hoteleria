package com.tcg.gateway.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
      .csrf(csrf -> csrf.disable())
      .authorizeHttpRequests(auth -> auth
        .requestMatchers("/actuator/health").permitAll()
        .requestMatchers(HttpMethod.GET, "/**").hasAnyRole("USER","ADMIN")
        .requestMatchers(HttpMethod.POST, "/**").hasAnyRole("USER","ADMIN")
        .requestMatchers(HttpMethod.PUT, "/**").hasRole("ADMIN")
        .requestMatchers(HttpMethod.PATCH, "/**").hasRole("ADMIN")
        .requestMatchers(HttpMethod.DELETE, "/**").hasRole("ADMIN")
        .anyRequest().authenticated()
      )
      .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()));
    return http.build();
  }
}
