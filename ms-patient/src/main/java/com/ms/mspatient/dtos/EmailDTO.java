package com.ms.mspatient.dtos;

import lombok.Data;

@Data
public class EmailDTO {
    private Long patientId;
    private String emailTo;
    private String subject;
    private String text;
}
