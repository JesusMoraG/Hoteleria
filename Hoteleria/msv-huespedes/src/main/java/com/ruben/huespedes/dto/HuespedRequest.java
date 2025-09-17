package com.ruben.huespedes.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class HuespedRequest {

    @NotBlank
    @Size(max = 60)
    private String nombre;

    @NotBlank
    @Email
    @Size(max = 80)
    private String email;

    @Size(max = 20)
    private String telefono;

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
}
