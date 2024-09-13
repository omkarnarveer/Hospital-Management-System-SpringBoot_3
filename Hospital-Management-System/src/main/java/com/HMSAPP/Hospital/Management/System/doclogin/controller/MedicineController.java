package com.HMSAPP.Hospital.Management.System.doclogin.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.HMSAPP.Hospital.Management.System.doclogin.enity.Medicine;
import com.HMSAPP.Hospital.Management.System.doclogin.repository.MedicineRepository;

@CrossOrigin(origins = "http://localhost:4200") // Specific origin
@RestController
@RequestMapping("/api/v3")
public class MedicineController {

	private final MedicineRepository medicineRepository;

	public MedicineController(MedicineRepository medicineRepository) {
		this.medicineRepository = medicineRepository;
	}

	@PostMapping("/insert")
	public Medicine createMedicine(@RequestBody Medicine medicine) {
		return medicineRepository.save(medicine);
	}

	@GetMapping("/medicines")
	public List<Medicine> getAllMedicines() {
		return medicineRepository.findAll();
	}

	@GetMapping("/medicines/{id}")
	public ResponseEntity<Medicine> getMedicineById(@PathVariable Long id) {
		return medicineRepository.findById(id).map(medicine -> ResponseEntity.ok(medicine)).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Medicine not found with id " + id));
	}

	@DeleteMapping("/medicines/{id}")
	public ResponseEntity<?> deleteMedicine(@PathVariable Long id) {
		return medicineRepository.findById(id).map(medicine -> {
			medicineRepository.delete(medicine);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Medicine not found with id " + id));
	}

	@PutMapping("/medicines/{id}")
	public ResponseEntity<Medicine> updateMedicine(@PathVariable Long id, @RequestBody Medicine medicineDetails) {
		return medicineRepository.findById(id).map(medicine -> {
			medicine.setName(medicineDetails.getName());
			medicine.setBrand(medicineDetails.getBrand());
			medicine.setGenericName(medicineDetails.getGenericName());
			medicine.setDosageForm(medicineDetails.getDosageForm());
			medicine.setStrength(medicineDetails.getStrength());
			medicine.setQuantity(medicineDetails.getQuantity());
			medicine.setExpirationDate(medicineDetails.getExpirationDate());
			medicine.setPrice(medicineDetails.getPrice());
			medicine.setPrescriptionRequired(medicineDetails.isPrescriptionRequired());
			Medicine updatedMedicine = medicineRepository.save(medicine);
			return ResponseEntity.ok(updatedMedicine);
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Medicine not found with id " + id));
	}
}