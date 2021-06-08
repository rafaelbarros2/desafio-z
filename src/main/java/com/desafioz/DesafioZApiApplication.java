package com.desafioz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DesafioZApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioZApiApplication.class, args);
	}

}
