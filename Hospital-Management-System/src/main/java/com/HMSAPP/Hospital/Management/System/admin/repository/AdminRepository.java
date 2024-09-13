package com.HMSAPP.Hospital.Management.System.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HMSAPP.Hospital.Management.System.admin.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
}