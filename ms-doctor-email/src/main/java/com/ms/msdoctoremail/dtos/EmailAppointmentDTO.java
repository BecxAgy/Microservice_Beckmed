package com.ms.msdoctoremail.dtos;

public record EmailAppointmentDTO(Long id, String emailDoctorTo, String emailPatientTo, String subject, String text) {
}
