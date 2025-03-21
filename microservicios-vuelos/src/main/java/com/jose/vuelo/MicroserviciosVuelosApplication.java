package com.jose.vuelo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({"com.jose.commons.models.entities"})
public class MicroserviciosVuelosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosVuelosApplication.class, args);
	}

}
