package com.example.demo;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
	// @SpringBootApplication --> it will search for this annotation... Any class which has ths annotation will 
	// be the starting point of the sprint application
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
