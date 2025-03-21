package com.jose.commons.models.entities;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "AVIONES")
public class Avion {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AVION_SEQ")
	@SequenceGenerator(name = "AVION_SEQ", sequenceName = "AVION_SEQ", allocationSize=1)
	@Column(name = "ID_AVION")
	private Long id;
	
	@Column(name = "NUM_REGISTRO")
	@NotNull(message = "El numero de registro del avion es obligatorio")
	@Min(value= 1000, message = "El numero de registro debe ser al menos 1000")
	private Long numeroRegistro;

	@Column(name = "TIPO")
	@NotBlank(message = "El tipo de avion es obligatorio")
	@Size(min= 1, max = 50, message = "El tipo debe tener entre 1 y 50 caracteres")
	private String tipo;
	
	@Column(name = "CODIGO_MODELO")
	@NotBlank(message = "El codigo modelo del avion es obligatorio")
	@Size(min= 1, max = 50, message = "El codigo modelo del avion debe tener entre 1 y 50 caracteres")
	private String codigoModelo;
	
	@Column(name = "CAPACIDAD")
	@NotNull(message = "La capacidad del avion es obligatorio")
	@Min(value=0, message = "La capacidad debe ser al menos 0")
	private Long capacidad;
	
	@Column(name = "FECHA_PRIMER_VUELO")
	@NotNull(message = "La fecha del primer vuelo es obligatorio")
	@Past(message="La fecha del primer vuelo debe ser anterior a la fecha actual")
	private LocalDate fechaPrimerVuelo;
	
	@Column(name = "ID_ESTATUS")
	@NotNull(message = "El estatus es obligatorio")
	@Min(value = 1, message = "El estatus debe ser al menos 1")
	@Max(value = 2, message = "El estatus no debe ser mayor a 2")
	private Long estatus;
	
	@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_AEROLINEA", referencedColumnName = "ID_AEROLINEA")	
	@NotNull(message = "La aerolinea es obligatoria")
	private Aerolinea idAerolinea;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNumeroRegistro() {
		return numeroRegistro;
	}

	public void setNumeroRegistro(Long numeroRegistro) {
		this.numeroRegistro = numeroRegistro;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCodigoModelo() {
		return codigoModelo;
	}

	public void setCodigoModelo(String codigoModelo) {
		this.codigoModelo = codigoModelo;
	}

	public Long getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Long capacidad) {
		this.capacidad = capacidad;
	}

	public LocalDate getFechaPrimerVuelo() {
		return fechaPrimerVuelo;
	}

	public void setFechaPrimerVuelo(LocalDate fechaPrimerVuelo) {
		this.fechaPrimerVuelo = fechaPrimerVuelo;
	}

	public Long getEstatus() {
		return estatus;
	}

	public void setEstatus(Long estatus) {
		this.estatus = estatus;
	}

	public Aerolinea getIdAerolinea() {
		return idAerolinea;
	}

	public void setIdAerolinea(Aerolinea idAerolinea) {
		this.idAerolinea = idAerolinea;
	}
	
}//Avion
