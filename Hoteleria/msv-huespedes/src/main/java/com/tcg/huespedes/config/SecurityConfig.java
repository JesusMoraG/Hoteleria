package com.tcg.huespedes.config;

import java.util.*;
import java.util.stream.Collectors;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

  @Bean
  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.csrf(csrf -> csrf.disable());
    http.authorizeHttpRequests(auth -> auth
        .requestMatchers("/actuator/**").permitAll()
        .anyRequest().authenticated());
    http.oauth2ResourceServer(oauth -> oauth.jwt(jwt -> jwt.jwtAuthenticationConverter(jwtAuthConverter())));
    return http.build();
  }

  @Bean
  JwtAuthenticationConverter jwtAuthConverter() {
    JwtAuthenticationConverter c = new JwtAuthenticationConverter();
    c.setJwtGrantedAuthoritiesConverter(this::extractAuthorities);
    return c;
  }

  private Collection<GrantedAuthority> extractAuthorities(Jwt jwt) {
    Collection<String> roles = new ArrayList<>();
    Object r = jwt.getClaims().get("roles");
    if (r instanceof Collection<?> col) {
      for (Object o : col) if (o != null) roles.add(o.toString());
    }
    Object a = jwt.getClaims().get("authorities");
    if (a instanceof Collection<?> col) {
      for (Object o : col) if (o != null) roles.add(o.toString());
    }
    return roles.stream()
        .map(s -> s.startsWith("ROLE_") ? s : "ROLE_" + s)
        .map(SimpleGrantedAuthority::new)
        .collect(Collectors.toSet());
  }
}
