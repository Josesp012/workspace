package com.jose.aeropuerto.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jose.aeropuerto.services.AeropuertoService;
import com.jose.commons.controllers.CommonController;
import com.jose.commons.models.entities.Aeropuerto;

import jakarta.validation.Valid;


@RestController
public class AeropuertoController extends CommonController<Aeropuerto, AeropuertoService>{
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Aeropuerto aeropuerto, 
			BindingResult result, @PathVariable Long id){
		if(result.hasErrors()) {
			return this.validar(result);
		}
		Aeropuerto aeropuertoDb = service.actualizar(aeropuerto, id);
	if (aeropuertoDb!=null) {
		return ResponseEntity.status(HttpStatus.CREATED).body(aeropuertoDb);
	}
	return ResponseEntity.notFound().build();

	}
}//AeropuertoController
