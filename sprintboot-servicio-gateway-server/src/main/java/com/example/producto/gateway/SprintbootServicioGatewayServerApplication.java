package com.example.producto.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SprintbootServicioGatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SprintbootServicioGatewayServerApplication.class, args);
	}

}
