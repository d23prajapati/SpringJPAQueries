package com.coding.JPA.hospitalManagement.repository;

import com.coding.JPA.hospitalManagement.dto.BloodGroupCountResponse;
import com.coding.JPA.hospitalManagement.entity.Patient;
import com.coding.JPA.hospitalManagement.entity.enums.BloodGroup;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    Patient findByName(String name);

    List<Patient> findByEmailOrBirthDateOrderByIdDesc(String email, LocalDate birthDate);

    List<Patient> findByNameContaining(String query);

    @Query("SELECT p FROM Patient p where p.bloodGroup = ?1")
    List<Patient> getPatientByBloodGroup(@Param("bloodGroup") BloodGroup bloodGroup);

    @Query("select p from Patient p where p.birthDate > :birthDate")
    List<Patient> getPatientsAfterDate(@Param("birthDate") LocalDate date);

//    @Query(value = "select * from patient", nativeQuery = true)
//    List<Patient> getAllPatients();

    @Query(value = "select * from patient", nativeQuery = true)
    Page<Patient> getAllPatients(Pageable pageable);

//    @Query("select bloodGroup, count(p) from Patient p group by p.bloodGroup")
//    List<Object[]> getBloodGroupCount();

    @Query("select new com.coding.JPA.hospitalManagement.dto.BloodGroupCountResponse(bloodGroup, count(p))" +
            " from Patient p group by p.bloodGroup")
    List<BloodGroupCountResponse> getBloodGroupCount();

    @Transactional
    @Modifying
    @Query("update Patient p set p.name = :name where p.id = :id")
    int updateNameWithId(@Param("name") String name,@Param("id") Long id);

    @Query("SELECT p FROM Patient p LEFT JOIN FETCH p.appointments")
    public List<Patient> findAllPatientsWithAppointment();
}
