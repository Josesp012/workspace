package com.jose.aeropuerto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jose.commons.models.entities.Aeropuerto;


public interface AeropuertoRepository extends JpaRepository<Aeropuerto,Long>{
	
}//AeropuertoRepository
