package com.tcg.huespedes.dto;

import jakarta.validation.constraints.*;

public class HuespedRequest {

    @NotBlank
    @Size(min = 10, max = 100)
    private String nombre;

    @NotBlank
    @Size(min = 10, max = 100)
    private String apellido;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Pattern(regexp = "\\d{10}")
    private String telefono;

    @NotBlank
    @Size(max = 20)
    private String documento;

    @NotBlank
    @Size(max = 50)
    private String nacionalidad;

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getDocumento() { return documento; }
    public void setDocumento(String documento) { this.documento = documento; }
    public String getNacionalidad() { return nacionalidad; }
    public void setNacionalidad(String nacionalidad) { this.nacionalidad = nacionalidad; }
}
