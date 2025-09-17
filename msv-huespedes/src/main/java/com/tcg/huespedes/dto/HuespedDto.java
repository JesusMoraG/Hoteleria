package com.tcg.huespedes.dto;

import jakarta.validation.constraints.*;

public class HuespedDto {
    private Long id;
    @NotBlank @Size(max = 40)
    private String nombre;
    @NotBlank @Size(max = 40)
    private String apellido;
    @Email @Size(max = 80)
    private String email;
    @Size(max = 20)
    private String telefono;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
}
