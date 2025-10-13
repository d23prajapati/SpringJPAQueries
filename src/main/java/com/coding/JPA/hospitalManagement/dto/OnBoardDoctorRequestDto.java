package com.coding.JPA.hospitalManagement.dto;

import lombok.Data;

@Data
public class OnBoardDoctorRequestDto {
    Long userId;
    String specialization;
    String name;
    String email;
}
