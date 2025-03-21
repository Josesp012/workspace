package com.jose.avion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EntityScan({"com.jose.commons.models.entities"})
@EnableFeignClients
public class MicroserviciosAvionApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosAvionApplication.class, args);
	}

}
