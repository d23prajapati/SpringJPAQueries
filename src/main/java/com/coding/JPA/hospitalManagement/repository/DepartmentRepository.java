package com.coding.JPA.hospitalManagement.repository;

import com.coding.JPA.hospitalManagement.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}