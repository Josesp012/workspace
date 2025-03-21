package com.jose.avion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jose.commons.models.entities.Avion;


public interface AvionRepository extends JpaRepository<Avion,Long>{
	
}
