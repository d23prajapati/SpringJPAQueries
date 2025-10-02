package com.coding.JPA.hospitalManagement.services;

import com.coding.JPA.hospitalManagement.dto.AppointmentResponseDto;
import com.coding.JPA.hospitalManagement.dto.CreateAppointmentRequestDto;
import com.coding.JPA.hospitalManagement.entity.Appointment;
import com.coding.JPA.hospitalManagement.entity.Doctor;
import com.coding.JPA.hospitalManagement.entity.Patient;
import com.coding.JPA.hospitalManagement.repository.AppointmentRepository;
import com.coding.JPA.hospitalManagement.repository.DoctorRepository;
import com.coding.JPA.hospitalManagement.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;
    private final AppointmentRepository appointmentRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public AppointmentResponseDto createNewAppointment(CreateAppointmentRequestDto createAppointmentRequestDto) {
        Long doctorId = createAppointmentRequestDto.getDoctorId();
        Long patientId = createAppointmentRequestDto.getPatientId();

        Patient patient = patientRepository.findById(patientId).orElseThrow();
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();

        Appointment appointment = Appointment.builder()
                .reason(createAppointmentRequestDto.getReason())
                .appointmentTime(createAppointmentRequestDto.getAppointmentTime())
                .build();

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        patient.getAppointments().add(appointment);  // Maintain bidirectional consistency
        doctor.getAppointments().add(appointment);   // Maintain bidirectional consistency

        appointment = appointmentRepository.save(appointment);
        return modelMapper.map(appointment, AppointmentResponseDto.class);
    }

    @Transactional
    public Appointment reAssignApointment(Long appointmentId, Long doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow();

        appointment.setDoctor(doctor); // this will automatically call the update, because it is dirty

        doctor.getAppointments().add(appointment); // To maintain bidirectional consistency

        return appointment;
    }

//    @Transactional
//    public List<Appointment> createNewAppointment(List<Appointment> appointments, Long doctorId, Long patientId) {
//        Patient patient = patientRepository.findById(patientId).orElseThrow();
//        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();
//
//        appointments.forEach(appointment -> {
//            patient.getAppointments().add(appointment);
//            appointment.setPatient(patient);
//            appointment.setDoctor(doctor);
//        });
//
//        return appointmentRepository.saveAll(appointments);
//    }

    public List<AppointmentResponseDto> getAllAppointments() {
        return appointmentRepository.findAll()
                .stream()
                .map(appointment -> modelMapper.map(appointment, AppointmentResponseDto.class))
                .collect(Collectors.toList());
    }
}
