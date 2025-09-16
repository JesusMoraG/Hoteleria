package com.tcg.habitaciones.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "HABITACIONES", uniqueConstraints = {    @UniqueConstraint(columnNames = "numero")})
public class Habitacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false, unique = true)
    private Integer numero;

    @NotBlank
    @Size(max = 50)
    @Column(nullable = false, length = 50)
    private String tipo; // Individual, Doble, Suite

    @Size(max = 255)
    @Column(length = 255)
    private String descripcion;

    @NotNull
    @DecimalMin(value = "0.01", inclusive = true)
    @Digits(integer = 10, fraction = 2)
    @Column(nullable = false, precision = 10, scale = 2)
    private Double precio;

    @NotNull
    @Min(1)
    @Column(nullable = false)
    private Integer capacidad;

    @NotBlank
    @Column(nullable = false, length = 20)
    @Pattern(regexp = "Disponible|Ocupada|Limpieza|Mantenimiento")
    private String estado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
    
    
}
