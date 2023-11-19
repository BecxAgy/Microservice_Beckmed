package com.ms.msappointment.dtos;

import lombok.Data;

@Data
public class EmailAppointmentDTO {
    private Long id;
    private String emailDoctorTo;
    private String emailPatientTo;
    private String subject;
    private String text;
}
