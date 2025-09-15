package com.tcg.roles.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ROLES")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROL_SEQ")
    @SequenceGenerator(name = "ROL_SEQ", sequenceName = "ROL_SEQ", allocationSize = 1)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String nombre;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
}
