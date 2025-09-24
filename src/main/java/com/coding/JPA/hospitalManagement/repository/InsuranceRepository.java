package com.coding.JPA.hospitalManagement.repository;

import com.coding.JPA.hospitalManagement.entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
}