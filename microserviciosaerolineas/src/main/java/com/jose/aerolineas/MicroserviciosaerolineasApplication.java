package com.jose.aerolineas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({"com.jose.commons.models.entities"})
public class MicroserviciosaerolineasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosaerolineasApplication.class, args);
	}

}
