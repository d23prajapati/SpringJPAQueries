package com.coding.JPA.hospitalManagement;

import com.coding.JPA.hospitalManagement.dto.BloodGroupCountResponse;
import com.coding.JPA.hospitalManagement.entity.Patient;
import com.coding.JPA.hospitalManagement.entity.enums.BloodGroup;
import com.coding.JPA.hospitalManagement.repository.PatientRepository;
import com.coding.JPA.hospitalManagement.services.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class PatientRepositoryTest {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Test
    public void testPatientRepository(){
//        List<Patient> patients = patientRepository.findAll();
        List<Patient> patients = patientRepository.findAllPatientsWithAppointment();
        System.out.println(patients);
    }
//
//    @Test
//    public void testPatientService(){
//        Patient patient = patientService.getPatientById(1L);
//        System.out.println(patient);
//    }

    @Test
    public void testPatientJPAQuery(){

//        List<Patient> patients = patientRepository.findByEmailOrBirthDateOrderByIdDesc("john.doe@example.com",
//                LocalDate.of(1985, 11, 23));

//        List<Patient> patients = patientRepository.findByNameContaining("j");

//        List<Patient> patients = patientRepository.getPatientByBloodGroup(BloodGroup.A_POSITIVE);

//        List<Patient> patients = patientRepository.getPatientsAfterDate(LocalDate.of(1992,01, 01));

        Page<Patient> patients = patientRepository.getAllPatients(PageRequest.of(1, 2,
                Sort.by("name")));

//        List<Object[]> patients = patientRepository.getBloodGroupCount();

        for(Patient patient: patients) {
            System.out.println(patient);
        }

//        for(Object[] object: patients) {
//            System.out.println(object[0] + " " + object[1]);
//        }

//          int updatedRow = patientRepository.updateNameWithId("daniyal", 19L);
//        System.out.println("Rows updated: " + updatedRow);

//        List<BloodGroupCountResponse> bloodGroupCounts = patientRepository.getBloodGroupCount();
//        for(BloodGroupCountResponse response: bloodGroupCounts){
//            System.out.println(response);
//        }

    }
}
