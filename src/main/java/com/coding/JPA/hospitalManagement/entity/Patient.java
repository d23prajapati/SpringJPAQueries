package com.coding.JPA.hospitalManagement.entity;

import com.coding.JPA.hospitalManagement.entity.enums.BloodGroup;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(
        uniqueConstraints = {
                @UniqueConstraint(name = "unique_patient_email_name", columnNames = {"email","name"})
        },
        indexes = {
                @Index(name="idx_patient_birthdate", columnList = "birthDate")
        }
)
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

//    @ToString.Exclude
    private LocalDate birthDate;

    @Column(unique = true)
    private String email;

    private String gender;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private BloodGroup bloodGroup;
}
