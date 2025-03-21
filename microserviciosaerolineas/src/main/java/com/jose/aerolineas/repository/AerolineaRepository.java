package com.jose.aerolineas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jose.commons.models.entities.Aerolinea;

public interface AerolineaRepository extends JpaRepository<Aerolinea,Long>{
	
}
