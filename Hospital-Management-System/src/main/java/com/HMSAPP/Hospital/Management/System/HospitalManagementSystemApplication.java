package com.HMSAPP.Hospital.Management.System;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200") // Allowing CORS for Angular development server
@SpringBootApplication
public class HospitalManagementSystemApplication {

	public static void main(String[] args) {

		SpringApplication.run(HospitalManagementSystemApplication.class, args);
		System.out.println("Application Running");
	}
}