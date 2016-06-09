package com.rolandtalvar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SmartphonesApplication {

	private static final Logger logger = LoggerFactory.getLogger("smartphoneLogger");

	public static void main(String[] args) {
		SpringApplication.run(SmartphonesApplication.class, args);
		logger.info("Application started");
	}
}
