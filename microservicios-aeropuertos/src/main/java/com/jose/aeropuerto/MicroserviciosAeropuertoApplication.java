package com.jose.aeropuerto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({"com.jose.commons.models.entities"})
public class MicroserviciosAeropuertoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosAeropuertoApplication.class, args);
	}

}
