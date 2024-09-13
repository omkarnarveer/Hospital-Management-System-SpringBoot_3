package com.HMSAPP.Hospital.Management.System.adminController;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HMSAPP.Hospital.Management.System.admin.Admin;
import com.HMSAPP.Hospital.Management.System.admin.repository.AdminRepository;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

	private final AdminRepository adminRepository;

	public AdminController(AdminRepository adminRepository) {
		this.adminRepository = adminRepository;
	}

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody Admin admin) {
		Optional<Admin> existingAdmin = adminRepository.findById(admin.getId());

		if (existingAdmin.isPresent() && existingAdmin.get().getPassword().equals(admin.getPassword())) {
			return ResponseEntity.ok("Login successful");
		} else {
			return ResponseEntity.status(401).body("Invalid credentials");
		}
	}

	// Add admin data manually (initial setup)
	@PostMapping("/add")
	public ResponseEntity<String> addAdmin(@RequestBody Admin admin) {
		adminRepository.save(admin);
		return ResponseEntity.ok("Admin added successfully");
	}
}