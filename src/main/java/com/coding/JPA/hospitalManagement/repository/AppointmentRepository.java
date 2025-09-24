package com.coding.JPA.hospitalManagement.repository;

import com.coding.JPA.hospitalManagement.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}