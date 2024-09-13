package com.HMSAPP.Hospital.Management.System.doclogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.HMSAPP.Hospital.Management.System.doclogin.enity.Medicine;

@CrossOrigin(origins = "http://localhost:4200") // Allowing CORS for Angular development server
@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long> {

}