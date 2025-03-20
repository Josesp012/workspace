package com.jose.demo.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jose.demo.models.entities.Producto;

public interface ProductoRepository extends JpaRepository<Producto,Long>{
	
}//ProductoRepository
