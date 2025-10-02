package com.coding.JPA.hospitalManagement.services;

import com.coding.JPA.hospitalManagement.dto.PatientResponseDto;
import com.coding.JPA.hospitalManagement.entity.Appointment;
import com.coding.JPA.hospitalManagement.entity.Patient;
import com.coding.JPA.hospitalManagement.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;
    private final ModelMapper modelMapper;

    public PatientResponseDto getPatientById(Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Patient not found with id " + id));

        return modelMapper.map(patient, PatientResponseDto.class);
    }

    public List<PatientResponseDto> getAllPatients(Integer pageNumber, Integer pageSize) {
        Page<Patient> patients = patientRepository.findAll(PageRequest.of(pageNumber, pageSize));

        return patients.stream()
                .map(patient -> modelMapper.map(patient, PatientResponseDto.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public void removePatient(Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow();

        patientRepository.delete(patient);
    }
}
