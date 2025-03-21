package com.jose.vuelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jose.vuelo.model.entity.Vuelo;



public interface VueloRepository extends JpaRepository<Vuelo,Long>{

}
