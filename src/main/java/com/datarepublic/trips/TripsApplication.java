package com.datarepublic.trips;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class TripsApplication {

	public static void main(String[] args) {

		SpringApplication.run(TripsApplication.class, args);
	}

}
