package com.luv2code.springcoredemo;

import org.springframework.boot.SpringApplication;	//Bootstrap your Spring Boot application
import org.springframework.boot.autoconfigure.SpringBootApplication;	//Enables: Auto configuration; Component scanning; Additional configuration. Composed of @EnableAutoConfiguration, @ComponentScan, @Configuration


@SpringBootApplication
public class SpringcoredemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcoredemoApplication.class, args);
	}

}
