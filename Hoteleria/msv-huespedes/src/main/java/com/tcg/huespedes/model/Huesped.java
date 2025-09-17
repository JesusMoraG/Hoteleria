package com.tcg.huespedes.model;

import jakarta.persistence.*;

@Entity
@Table(name = "HUESPEDES")
public class Huesped {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HUESPEDES_SEQ")
    @SequenceGenerator(name = "HUESPEDES_SEQ", sequenceName = "HUESPEDES_SEQ", allocationSize = 1)
    private Long id;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false, length = 50)
    private String apellido;

    @Column(nullable = false, unique = true, length = 20)
    private String documento;
    
    @Column(nullable = false, unique = true, length = 100)
    private String email;
    
    @Column(nullable = false, length = 15)
    private String telefono;
    
    @Column(nullable = false, length = 50)
    private String nacionalidad;



    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getDocumento() { return documento; }
    public void setDocumento(String documento) { this.documento = documento; }
	
    public String getEmail() { return email; }
	public void setEmail(String email) {this.email = email;	}
	
	public String getTelefono() { return telefono; }
	public void setTelefono(String telefono) { this.telefono = telefono; }
	
	public String getNacionalidad() { return nacionalidad; }
	public void setNacionalidad(String nacionalidad) { this.nacionalidad = nacionalidad; }
    
    
}
