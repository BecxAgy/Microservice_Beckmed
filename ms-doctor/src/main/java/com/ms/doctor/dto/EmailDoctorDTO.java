package com.ms.doctor.dto;

import lombok.Data;

@Data
public class EmailDoctorDTO {
    private Long doctorId;
    private String emailTo;
    private String subject;
    private String text;
}
