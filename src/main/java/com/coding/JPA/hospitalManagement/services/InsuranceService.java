package com.coding.JPA.hospitalManagement.services;

import com.coding.JPA.hospitalManagement.entity.Insurance;
import com.coding.JPA.hospitalManagement.entity.Patient;
import com.coding.JPA.hospitalManagement.repository.InsuranceRepository;
import com.coding.JPA.hospitalManagement.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {
    private final PatientRepository patientRepository;
    private final InsuranceRepository insuranceRepository;

    @Transactional
    public Patient assignInsuranceToPatient(Insurance insurance, Long patientId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(()-> new EntityNotFoundException("Unable to find patient with ID: "+ patientId));

        patient.setInsurance(insurance);
        insurance.setPatient(patient); // Bidirectional consistency maintenance

        return patient;
    }

    @Transactional
    public Patient disassociateInsuranceFromPatient(Long patientId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(()-> new EntityNotFoundException("Unable to find patient with ID: "+ patientId));

        patient.setInsurance(null);

        return patient;
    }
}
