package com.coding.JPA.hospitalManagement.dto;

import com.coding.JPA.hospitalManagement.entity.enums.RoleType;
import lombok.Data;

import java.util.Set;

@Data
public class SignUpRequestDto {
    private String username;
    private String password;
    private String name;

    private Set<RoleType> roles;
}
