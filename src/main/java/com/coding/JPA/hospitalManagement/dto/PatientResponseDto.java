package com.coding.JPA.hospitalManagement.dto;

import com.coding.JPA.hospitalManagement.entity.enums.BloodGroup;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientResponseDto {
    private Long id;
    private String name;
    private String gender;
    private LocalDate birthDate;
    private BloodGroup bloodGroup;
}