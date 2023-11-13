package com.ms.doctor.dto;

import lombok.Data;

@Data
public class EmailDoctorDTO {
    private Long id;
    private String emailTo;
    private String subject;
    private String text;
}
