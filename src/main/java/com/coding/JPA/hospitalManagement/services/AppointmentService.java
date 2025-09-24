package com.coding.JPA.hospitalManagement.services;

import com.coding.JPA.hospitalManagement.entity.Appointment;
import com.coding.JPA.hospitalManagement.entity.Doctor;
import com.coding.JPA.hospitalManagement.entity.Patient;
import com.coding.JPA.hospitalManagement.repository.AppointmentRepository;
import com.coding.JPA.hospitalManagement.repository.DoctorRepository;
import com.coding.JPA.hospitalManagement.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;
    private final AppointmentRepository appointmentRepository;

    @Transactional
    public Appointment createNewAppointment(Appointment appointment, Long doctorId, Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow();
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();

        if(appointment.getId() != null) throw new IllegalArgumentException("Appointment must not exist in database");

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        patient.getAppointments().add(appointment);  // Maintain bidirectional consistency
        doctor.getAppointments().add(appointment);   // Maintain bidirectional consistency

        return appointmentRepository.save(appointment);
    }

    @Transactional
    public Appointment reAssignApointment(Long appointmentId, Long doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow();

        appointment.setDoctor(doctor); // this will automatically call the update, because it is dirty

        doctor.getAppointments().add(appointment); // To maintain bidirectional consistency

        return appointment;
    }

    @Transactional
    public List<Appointment> createNewAppointment(List<Appointment> appointments, Long doctorId, Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow();
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();

        appointments.forEach(appointment -> {
            patient.getAppointments().add(appointment);
            appointment.setPatient(patient);
            appointment.setDoctor(doctor);
        });


        return appointmentRepository.saveAll(appointments);
    }
}
