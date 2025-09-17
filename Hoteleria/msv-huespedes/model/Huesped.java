package com.tcg.huespedes.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
@Entity
@Table(name = "HUESPEDES")
public class Huesped {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank private String nombre;
    @NotBlank @Email @Column(unique = true) private String email;
    private String telefono;
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
}
