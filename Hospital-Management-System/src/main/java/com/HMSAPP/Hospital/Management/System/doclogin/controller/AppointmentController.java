package com.HMSAPP.Hospital.Management.System.doclogin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.AttributeNotFoundException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HMSAPP.Hospital.Management.System.doclogin.enity.Appointment;
import com.HMSAPP.Hospital.Management.System.doclogin.repository.AppointmentsRepository;

@CrossOrigin(origins = "http://localhost:4200") // Allowing CORS for Angular development server
@RestController
@RequestMapping("/api/v2")
public class AppointmentController {

	private final AppointmentsRepository appointmentsRepository;

	public AppointmentController(AppointmentsRepository appointmentsRepository) {
		this.appointmentsRepository = appointmentsRepository;
	}

	@PostMapping("/insert")
	public Appointment createAppointment(@RequestBody Appointment appointment) {
		return appointmentsRepository.save(appointment);
	}

	@GetMapping
	public List<Appointment> getAllAppointments() {
		return appointmentsRepository.findAll();
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteAppointment(@PathVariable Long id)
			throws AttributeNotFoundException {
		Appointment appointment = appointmentsRepository.findById(id)
				.orElseThrow(() -> new AttributeNotFoundException("Appointment not found with id: " + id));
		appointmentsRepository.delete(appointment);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}