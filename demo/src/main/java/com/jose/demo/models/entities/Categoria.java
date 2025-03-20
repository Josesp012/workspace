package com.jose.demo.models.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="CATEGORIA_TEMPORAL")
public class Categoria {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="TEST_SEQ")
	@SequenceGenerator(name="TEST_SEQ",sequenceName="TEST_SEQ", allocationSize=1)
	@Column(name="ID_CATEGORIA")
	private Long id;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="DESCRIPCION")
	private String descripcion;
	
	@Column(name="FECHA_CREACION",updatable=false)
	private Date fechaCreacion;
	
	@OneToMany(mappedBy="categoria")
	@JsonManagedReference
	private List<Producto> productos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	public void addProducto(Producto producto) {
		this.productos.add(producto);
	}
	
	public void removeProducto(Producto producto) {
		this.productos.remove(producto);
	}
	
	@PrePersist
	public void prePersist() {
		this.fechaCreacion= new Date();
		this.productos= new ArrayList<>();
	}
}
