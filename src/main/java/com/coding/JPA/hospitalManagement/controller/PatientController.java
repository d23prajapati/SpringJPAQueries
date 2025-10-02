package com.coding.JPA.hospitalManagement.controller;

import com.coding.JPA.hospitalManagement.dto.AppointmentResponseDto;
import com.coding.JPA.hospitalManagement.dto.CreateAppointmentRequestDto;
import com.coding.JPA.hospitalManagement.dto.PatientResponseDto;
import com.coding.JPA.hospitalManagement.services.AppointmentService;
import com.coding.JPA.hospitalManagement.services.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/patients")
public class PatientController {
    private final PatientService patientService;
    private final AppointmentService appointmentService;

    @PostMapping("/appointments")
    public ResponseEntity<AppointmentResponseDto> createNewAppointment(@RequestBody CreateAppointmentRequestDto createAppointmentRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(appointmentService.createNewAppointment(createAppointmentRequestDto));
    }

    @GetMapping("/profile")
    private ResponseEntity<PatientResponseDto> getPatientProfile() {
        Long patientId = 4L;
        return ResponseEntity.status(HttpStatus.OK).body(patientService.getPatientById(patientId));
    }
}
