package com.coding.JPA.hospitalManagement;

import com.coding.JPA.hospitalManagement.entity.Appointment;
import com.coding.JPA.hospitalManagement.services.AppointmentService;
import com.coding.JPA.hospitalManagement.services.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class AppointmentTests {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private PatientService patientService;

//    @Test
//    public void testCreateNewAppointment(){
//        Appointment appointment = Appointment.builder()
//                .appointmentTime(LocalDateTime.of(2025, 11, 12, 14,0))
//                .reason("Joint pain")
//                .build();
//
////        var newAppointment = appointmentService.createNewAppointment(appointment, 3L, 1L);
//
//        System.out.println(newAppointment);
//
//        var reassignedAppointment = appointmentService.reAssignApointment(newAppointment.getId(), 2L);
//
//        System.out.println(reassignedAppointment);
//    }

//    @Test
//    public void testAppointments() {
//        Appointment appointment1 = Appointment.builder()
//                .appointmentTime(LocalDateTime.of(2025, 11, 12, 14,0))
//                .reason("Joint pain")
//                .build();
//
//        Appointment appointment2 = Appointment.builder()
//                .appointmentTime(LocalDateTime.of(2025, 12, 1, 9,0))
//                .reason("Leg pain")
//                .build();
//
//        Appointment appointment3 = Appointment.builder()
//                .appointmentTime(LocalDateTime.of(2026, 1, 2, 13,45))
//                .reason("Hand pain")
//                .build();
//
//        List<Appointment> appointments = new ArrayList<>();
//        appointments.add(appointment1);
//        appointments.add(appointment2);
//        appointments.add(appointment3);
//
//        var appointmentList = appointmentService.createNewAppointment(appointments, 3L, 1L);
//
//        System.out.println(appointmentList);
//
//        patientService.removePatient(1L);
//    }
}
