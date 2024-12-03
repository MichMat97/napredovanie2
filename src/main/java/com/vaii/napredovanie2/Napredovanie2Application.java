package com.vaii.napredovanie2;

import com.vaii.napredovanie2.repository.UserRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Napredovanie2Application {

	public static void main(String[] args) {
		SpringApplication.run(Napredovanie2Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			System.out.println("Let's inspect the beans provided by Spring Boot:");
		};
	}
}
