package com.tcg.huespedes.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(
    name = "HUESPEDES",
    uniqueConstraints = {
        @UniqueConstraint(name = "UK_HUESPED_EMAIL", columnNames = "EMAIL"),
        @UniqueConstraint(name = "UK_HUESPED_TELEFONO", columnNames = "TELEFONO")
    }
)
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
    @Column(name = "EMAIL", nullable = false, length = 150)
    private String email;

    @NotBlank
    @Pattern(regexp = "^[0-9]{10}$", message = "El teléfono debe tener 10 dígitos")
    @Column(name = "TELEFONO", nullable = false, length = 20)
    private String telefono;

    @Column(name = "DOCUMENTO", length = 30)
    private String documento;

    @Column(name = "NACIONALIDAD", length = 60)
    private String nacionalidad;

    public Huesped() {}

    // Getters y setters
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
