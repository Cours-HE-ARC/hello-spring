package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class HelloSpringApplication {

	public static void main(String[] args) {
		System.out.println("Before start...");

		SpringApplication.run(HelloSpringApplication.class, args);

		System.out.println("After start...");
	}



}
