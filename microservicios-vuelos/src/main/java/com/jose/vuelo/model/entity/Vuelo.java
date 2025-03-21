package com.jose.vuelo.model.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jose.commons.models.entities.Aeropuerto;
import com.jose.commons.models.entities.Avion;

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
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "VUELO")
public class Vuelo {
	
	@Id
	@Column(name="ID_VUELO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="VUELO_SEQ")
	@SequenceGenerator(name="VUELO_SEQ", sequenceName="VUELO_SEQ", allocationSize=1)
	private Long id;
	
	@Column(name="CODIGO_VUELO")
	@NotBlank(message="El tipo de avion es obligatorio")
	@Size(min=1, max=50,message="El tipo de avion debe tener entre 1 y 50 caracteres")
	private String codigoVuelo;

	@JsonIgnoreProperties(value={"handler","hibernateLazyInitializer"})
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_AVION",referencedColumnName="ID_AVION")
	@NotNull(message="El numero de registro es obligatorio")
	private Avion idAvion;
	
	@JsonIgnoreProperties(value={"handler","hibernateLazyInitializer"})
	@ManyToOne(fetch=FetchType.LAZY)
	@NotNull(message="El ID de origen es obligatorio")
	@JoinColumn(name="ID_ORIGEN",referencedColumnName="ID_AEROPUERTO")
	private Aeropuerto idOrigen;
	
	@JsonIgnoreProperties(value={"handler","hibernateLazyInitializer"})
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_DESTINO",referencedColumnName="ID_AEROPUERTO")
	@NotNull(message="El numero de destino es obligatorio")
	private Aeropuerto idDestino;

	@Column(name="FECHA_SALIDA")
	@NotNull(message="La fecha de salida es obligatoria")
	private LocalDate fechaSalida;
	
	@Column(name="ID_ESTATUS")
	@NotNull(message="El estatus es obligatorio")
	@Min(value=1,message="El estatus debe ser al menos 1")
	@Max(value=2,message="El estatus no debe ser mayor 2")
	private Long estatus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigoVuelo() {
		return codigoVuelo;
	}

	public void setCodigoVuelo(String codigoVuelo) {
		this.codigoVuelo = codigoVuelo;
	}

	public Avion getIdAvion() {
		return idAvion;
	}

	public void setIdAvion(Avion idAvion) {
		this.idAvion = idAvion;
	}

	public Aeropuerto getIdOrigen() {
		return idOrigen;
	}

	public void setIdOrigen(Aeropuerto idOrigen) {
		this.idOrigen = idOrigen;
	}

	public Aeropuerto getIdDestino() {
		return idDestino;
	}

	public void setIdDestino(Aeropuerto idDestino) {
		this.idDestino = idDestino;
	}

	public LocalDate getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(LocalDate fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public Long getEstatus() {
		return estatus;
	}

	public void setEstatus(Long estatus) {
		this.estatus = estatus;
	}

	
}//Vuelo
