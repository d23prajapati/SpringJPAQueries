package com.coding.JPA.hospitalManagement.security;

import com.coding.JPA.hospitalManagement.dto.LoginRequestDto;
import com.coding.JPA.hospitalManagement.dto.LoginResponseDto;
import com.coding.JPA.hospitalManagement.dto.SignUpRequestDto;
import com.coding.JPA.hospitalManagement.dto.SignupResponseDto;
import com.coding.JPA.hospitalManagement.entity.Patient;
import com.coding.JPA.hospitalManagement.entity.User;
import com.coding.JPA.hospitalManagement.entity.enums.RoleType;
import com.coding.JPA.hospitalManagement.repository.PatientRepository;
import com.coding.JPA.hospitalManagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final AuthUtil authUtil;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final PatientRepository patientRepository;

    public LoginResponseDto login(LoginRequestDto loginRequestDto) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(), loginRequestDto.getPassword())
        );

        User user = (User) authentication.getPrincipal();

        String token = authUtil.generateAccessToken(user);

        return new LoginResponseDto(user.getId(), token);
    }

    public SignupResponseDto signUp(SignUpRequestDto signupRequestDto) {
        User user = userRepository.findByUsername(signupRequestDto.getUsername()).orElse(null);

        if(user != null) throw new IllegalArgumentException("User already exists");

        user = userRepository.save(
                User.builder()
                        .username(signupRequestDto.getUsername())
                        .password(passwordEncoder.encode(signupRequestDto.getPassword()))
                        .roles(signupRequestDto.getRoles())  // Set.of(RoleType.PATIENT)
                        .build()
        );

        Patient patient = Patient.builder()
                .name(signupRequestDto.getName())
                .email(signupRequestDto.getUsername())
                .user(user)
                .build();

        patientRepository.save(patient);

        return new SignupResponseDto(user.getId(), user.getUsername());
    }
}
