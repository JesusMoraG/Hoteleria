package com.tcg.huespedes.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "HUESPEDES",
       uniqueConstraints = {
         @UniqueConstraint(name = "uk_huesped_email", columnNames = "EMAIL"),
         @UniqueConstraint(name = "uk_huesped_telefono", columnNames = "TELEFONO")
       })
public class Huesped {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HUESPEDES_SEQ")
    @SequenceGenerator(name = "HUESPEDES_SEQ", sequenceName = "HUESPEDES_SEQ", allocationSize = 1)
    @Column(name = "ID")
    private Long id;

    @NotBlank
    @Size(min = 10, max = 100)
    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombre;

    @NotBlank
    @Size(min = 10, max = 100)
    @Column(name = "APELLIDO", nullable = false, length = 100)
    private String apellido;

    @NotBlank
    @Email
    @Column(name = "EMAIL", nullable = false, length = 100, unique = true)
    private String email;

    @NotBlank
    @Pattern(regexp = "\\d{10}")
    @Column(name = "TELEFONO", nullable = false, length = 15, unique = true)
    private String telefono;

    @NotBlank
    @Size(max = 20)
    @Column(name = "DOCUMENTO", nullable = false, length = 20)
    private String documento;

    @NotBlank
    @Size(max = 50)
    @Column(name = "NACIONALIDAD", nullable = false, length = 50)
    private String nacionalidad;

    public Huesped() {}

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
    public String getDocumento() { return documento; }
    public void setDocumento(String documento) { this.documento = documento; }
    public String getNacionalidad() { return nacionalidad; }
    public void setNacionalidad(String nacionalidad) { this.nacionalidad = nacionalidad; }
}
