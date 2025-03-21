package com.jose.aerolineas.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jose.aerolineas.services.AerolineaService;
import com.jose.commons.controllers.CommonController;
import com.jose.commons.models.entities.Aerolinea;

import jakarta.validation.Valid;

@RestController
public class AerolineasController extends CommonController<Aerolinea, AerolineaService> {
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Aerolinea aerolinea, 
			BindingResult result, @PathVariable Long id){
		if(result.hasErrors()) {
			return this.validar(result);
		}
		Aerolinea aerolineaDb = service.actualizar(aerolinea, id);
	if (aerolineaDb!=null) {
		return ResponseEntity.status(HttpStatus.CREATED).body(aerolineaDb);
	}
	return ResponseEntity.notFound().build();

	}
}
