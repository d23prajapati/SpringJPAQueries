package com.coding.JPA.hospitalManagement.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDto {
    Long id;
    String jwt;
}
