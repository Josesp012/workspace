package com.jose.aerolinea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({"com.jose.commons.models.entities"})
public class MicroserviciosAerolineasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosAerolineasApplication.class, args);
	}

}
