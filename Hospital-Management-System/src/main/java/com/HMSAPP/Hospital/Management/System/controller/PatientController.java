package com.HMSAPP.Hospital.Management.System.controller;

import com.HMSAPP.Hospital.Management.System.entity.Patient;
import com.HMSAPP.Hospital.Management.System.repository.PatientRepositiry;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class PatientController {

	private final PatientRepositiry PatientRepository;

	public PatientController(PatientRepositiry PatientRepository) {
		this.PatientRepository = PatientRepository;
	}

	@PostMapping("/insert")
	public Patient createPatient(@RequestBody Patient Patient) {
		return PatientRepository.save(Patient);
	}

	@GetMapping("/Patients")
	public List<Patient> getPatients() {
		return PatientRepository.findAll();
	}

	@GetMapping("/Patients/{id}")
	public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
		Optional<Patient> PatientOptional = PatientRepository.findById(id);
		if (PatientOptional.isPresent()) {
			return ResponseEntity.ok(PatientOptional.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Map<String, Boolean>> deletePatient(@PathVariable Long id) throws Exception {
		Patient appointment = PatientRepository.findById(id)
				.orElseThrow(() -> new Exception("Patient not found with id: " + id));
		PatientRepository.delete(appointment);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody Patient PatientDetails) {
		Optional<Patient> PatientOptional = PatientRepository.findById(id);
		if (!PatientOptional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Patient existingPatient = PatientOptional.get();
		existingPatient.setName(PatientDetails.getName());
		existingPatient.setAge(PatientDetails.getAge());
		existingPatient.setBlood(PatientDetails.getBlood());
		existingPatient.setPrescription(PatientDetails.getPrescription());
		existingPatient.setDose(PatientDetails.getDose());
		existingPatient.setFees(PatientDetails.getFees());
		existingPatient.setUrgency(PatientDetails.getUrgency());

		Patient updatedPatient = PatientRepository.save(existingPatient);
		return ResponseEntity.ok(updatedPatient);
	}
}