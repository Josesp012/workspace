package com.jose.avion.clients;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.jose.commons.models.entities.Aerolinea;

@FeignClient(name="microserviciosaerolineas")
public interface AerolineaClient {
	@GetMapping("/{id}")
	public Optional<Aerolinea> getAerolineaById(@PathVariable Long id);
	
	
}
