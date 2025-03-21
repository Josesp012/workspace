package com.jose.vuelo.dto;

import java.time.LocalDate;


import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class VueloDTO {

	private Long id;
	
	@NotBlank(message="El tipo de avion es obligatorio")
	@Size(max=50,message ="El codigo de vuelo no puede exceder los 50 caracteres")
	private String codigoVuelo;
	
	@NotNull(message="El id de avion es obligatorio")
	@Min(value=1, message="el id de avion no puede ser menor que 1")
	private Long idAvion;
	
	@NotNull(message="El ID de origen es obligatorio")
	@Min(value=1, message="el id de origen no puede ser menor que 1")
	private Long idOrigen;
	
	@NotNull(message="El numero de destino es obligatorio")
	@Min(value=1, message="el id de destino no puede ser menor que 1")
	private Long idDestino;
	
	@NotNull(message="La fecha de salida es obligatoria")
	@Future(message="La fecha de salida debe ser posterior a la fecha actual")
	private LocalDate fechaSalida;
	
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

	public Long getIdAvion() {
		return idAvion;
	}

	public void setIdAvion(Long idAvion) {
		this.idAvion = idAvion;
	}

	public Long getIdOrigen() {
		return idOrigen;
	}

	public void setIdOrigen(Long idOrigen) {
		this.idOrigen = idOrigen;
	}

	public Long getIdDestino() {
		return idDestino;
	}

	public void setIdDestino(Long idDestino) {
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
	
}//VueloDTO
