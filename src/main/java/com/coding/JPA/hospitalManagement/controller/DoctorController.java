package com.coding.JPA.hospitalManagement.controller;

import com.coding.JPA.hospitalManagement.dto.AppointmentResponseDto;
import com.coding.JPA.hospitalManagement.services.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/doctors")
public class DoctorController {
    private final AppointmentService appointmentService;

    @GetMapping("/appointments")
    public ResponseEntity<List<AppointmentResponseDto>> getAllAppointments() {
        return ResponseEntity.ok(appointmentService.getAllAppointments());
    }
}
