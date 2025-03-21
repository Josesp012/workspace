package com.jose.avion.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class AvionDTO {
	
	private Long id;
	
	@NotNull(message = "El numero de registro del avion es obligatorio")
	@Min(value= 1000, message = "El numero de registro debe ser al menos 1000")
	private Long numeroRegistro;
	
	@NotBlank(message = "El tipo de avion es obligatorio")
	@Size(min= 1, max = 50, message = "El tipo debe tener entre 1 y 50 caracteres")
	private String tipo;
	
	@NotBlank(message = "El codigo modelo del avion es obligatorio")
	@Size(min= 1, max = 50, message = "El codigo modelo del avion debe tener entre 1 y 50 caracteres")
	private String codigoModelo;
	
	@NotNull(message = "La capacidad del avion es obligatorio")
	@Min(value=0, message = "La capacidad debe ser al menos 0")
	private Long capacidad;
	
	@NotNull(message = "La fecha del primer vuelo es obligatorio")
	@Past(message="La fecha del primer vuelo debe ser anterior a la fecha actual")
	private LocalDate fechaPrimerVuelo;
	
	@NotNull(message = "El estatus es obligatorio")
	@Min(value = 1, message = "El estatus debe ser al menos 1")
	@Max(value = 2, message = "El estatus no debe ser mayor a 2")
	private Long estatus;
	
	@NotNull(message = "La aerolinea es obligatoria")
	@Min(value = 1, message = "El id Aerolinea debe ser al menos 1")
	private Long idAerolinea;

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

	public Long getIdAerolinea() {
		return idAerolinea;
	}

	public void setIdAerolinea(Long idAerolinea) {
		this.idAerolinea = idAerolinea;
	}
	
	
	
	
}//AvionDTO
