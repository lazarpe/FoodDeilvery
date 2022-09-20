package com.petrovic.fooddeliveryapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import spring rest controller annotation
import org.springframework.web.bind.annotation.RestController;
// import getmapping annotation
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@RestController
public class FoodDeliveryApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodDeliveryApiApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello() {
		return "Hello World!";
	}
}
