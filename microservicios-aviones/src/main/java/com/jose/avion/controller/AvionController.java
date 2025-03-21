package com.jose.avion.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jose.avion.dto.AvionDTO;
import com.jose.avion.services.AvionService;
import com.jose.commons.controllers.CommonController;
import com.jose.commons.models.entities.Avion;

import jakarta.validation.Valid;

@RestController
public class AvionController extends CommonController<Avion,AvionService>{
	
	@PostMapping("/avion-dto")
	public ResponseEntity<?> create(@Valid @RequestBody AvionDTO avionDto, BindingResult result){
		if (result.hasErrors()) {
			return this.validar(result);
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(service.createAvionDTO(avionDto));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody AvionDTO avionDTO, BindingResult result,
			@PathVariable Long id){
		if(result.hasErrors()) {
			return this.validar(result);
		}
		Avion avion = service.update(avionDTO, id);
		if(avionDTO != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(avion);
		}
		return ResponseEntity.notFound().build();
	}
}
