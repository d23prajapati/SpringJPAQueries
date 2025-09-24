package com.coding.JPA.hospitalManagement;

import com.coding.JPA.hospitalManagement.entity.Insurance;
import com.coding.JPA.hospitalManagement.entity.Patient;
import com.coding.JPA.hospitalManagement.services.InsuranceService;
import com.coding.JPA.hospitalManagement.services.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class InsuranceTests {
    @Autowired
    private InsuranceService insuranceService;

    @Test
    public void testAssignInsuranceToPatient() {

        Insurance insurance = Insurance.builder()
                .policyNumber("HDFC_1234")
                .provider("HDFC")
                .validUntil(LocalDate.of(2030, 12, 12))
                .build();

        Patient patient = insuranceService.assignInsuranceToPatient(insurance, 1L);

        System.out.println(patient);

        var updatedPatient = insuranceService.disassociateInsuranceFromPatient(patient.getId());

        System.out.println(updatedPatient);
    }

}
