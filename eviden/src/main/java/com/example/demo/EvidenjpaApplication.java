package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = "com.example.demo.demo.service.ManagerIdService")

public class EvidenjpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EvidenjpaApplication.class, args);
	}

}
