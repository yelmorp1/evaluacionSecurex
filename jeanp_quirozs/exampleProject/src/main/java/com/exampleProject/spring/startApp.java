package com.exampleProject.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class startApp {
	public static void main(String[] args) {
		SpringApplication.run(startApp.class, args);
	}
}
