package com.coding.JPA.hospitalManagement.dto;

import com.coding.JPA.hospitalManagement.entity.enums.BloodGroup;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BloodGroupCountResponse {
    private BloodGroup bloodGroup;
    private Long count;
}
