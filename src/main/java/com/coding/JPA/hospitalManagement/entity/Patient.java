package com.coding.JPA.hospitalManagement.entity;

import com.coding.JPA.hospitalManagement.entity.enums.BloodGroup;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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

    @Column(nullable = false, length = 40)
    private String name;

//    @ToString.Exclude
    private LocalDate birthDate;

    @Column(unique = true, nullable = false)
    private String email;

    private String gender;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private BloodGroup bloodGroup;

    @OneToOne
    @JoinColumn(name = "patient_insurance_id")
    private Insurance insurance; // owning side

    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments; // inverse side
}
