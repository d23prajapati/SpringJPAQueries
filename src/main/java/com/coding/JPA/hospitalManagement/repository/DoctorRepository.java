package com.coding.JPA.hospitalManagement.repository;

import com.coding.JPA.hospitalManagement.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}