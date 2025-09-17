package com.ruben.huespedes.dto;

public class HuespedResponse {
    private Long id;
    private String nombre;
    private String email;
    private String telefono;

    public HuespedResponse(Long id, String nombre, String email, String telefono) {
        this.id = id; this.nombre = nombre; this.email = email; this.telefono = telefono;
    }

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public String getTelefono() { return telefono; }
}
