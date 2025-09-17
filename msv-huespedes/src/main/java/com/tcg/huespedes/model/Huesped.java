package com.tcg.huespedes.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "HUESPEDES")
public class Huesped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotBlank @Size(max = 40)
    @Column(name = "NOMBRE", nullable = false, length = 40)
    private String nombre;

    @NotBlank @Size(max = 40)
    @Column(name = "APELLIDO", nullable = false, length = 40)
    private String apellido;

    @Email @Size(max = 80)
    @Column(name = "EMAIL", length = 80, unique = true)
    private String email;

    @Size(max = 20)
    @Column(name = "TELEFONO", length = 20)
    private String telefono;

    // getters/setters
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
