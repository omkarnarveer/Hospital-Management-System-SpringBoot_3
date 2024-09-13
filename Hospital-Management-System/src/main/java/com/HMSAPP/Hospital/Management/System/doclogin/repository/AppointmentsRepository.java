package com.HMSAPP.Hospital.Management.System.doclogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.HMSAPP.Hospital.Management.System.doclogin.enity.Appointment;


@CrossOrigin(origins = "http://localhost:4200") // Allowing CORS for Angular development server
public interface AppointmentsRepository extends JpaRepository<Appointment, Long> {

}