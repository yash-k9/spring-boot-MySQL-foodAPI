package com.devX.app.foodService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


// Food-Service port:8080
@EnableJpaRepositories(basePackages = "com.devX.app.foodService.repository")
@SpringBootApplication
public class FoodServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodServiceApplication.class, args);
	}

}
