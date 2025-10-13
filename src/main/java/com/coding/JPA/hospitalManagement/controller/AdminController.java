package com.coding.JPA.hospitalManagement.controller;

import com.coding.JPA.hospitalManagement.dto.DoctorResponseDto;
import com.coding.JPA.hospitalManagement.dto.OnBoardDoctorRequestDto;
import com.coding.JPA.hospitalManagement.dto.PatientResponseDto;
import com.coding.JPA.hospitalManagement.services.DoctorService;
import com.coding.JPA.hospitalManagement.services.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final PatientService patientService;
    private final DoctorService doctorService;

    @GetMapping("/patients")
    public ResponseEntity<List<PatientResponseDto>> getAllPatients(
            @RequestParam(value = "page", defaultValue = "0") Integer pageNumber,
            @RequestParam(value = "size", defaultValue = "10") Integer pageSize
    ) {
        return ResponseEntity.ok(patientService.getAllPatients(pageNumber, pageSize));
    }

    @PostMapping("/onBoardNewDoctor")
    public ResponseEntity<DoctorResponseDto> onBoardNewDoctor(@RequestBody OnBoardDoctorRequestDto onBoardDoctorRequestDto) {
        return ResponseEntity.ok(doctorService.onBoardNewDoctor(onBoardDoctorRequestDto));
    }
}
