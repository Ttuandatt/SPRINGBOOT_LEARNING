package com.luv2code.springcoredemo;

import org.springframework.boot.SpringApplication;	//Bootstrap your Spring Boot application
import org.springframework.boot.autoconfigure.SpringBootApplication;	//Enables: Auto configuration; Component scanning; Additional configuration. Composed of @EnableAutoConfiguration, @ComponentScan, @Configuration
/* //Explicitly list base packages to scan, if not then the application will fail to start as Coach & CricketCoach is in util package, which is not within the same package as SpringcoredemoApplication
@SpringBootApplication(
		scanBasePackages = {"com.luv2code.springcoredemo", "com.luv2code.util"}
)
*/
@SpringBootApplication
public class SpringcoredemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcoredemoApplication.class, args);
	}

}
