package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "Modele , Controlle")
public class AtelirApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtelirApplication.class, args);
	}

}
