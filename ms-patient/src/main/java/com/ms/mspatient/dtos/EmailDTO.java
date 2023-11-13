package com.ms.mspatient.dtos;

import lombok.Data;

@Data
public class EmailDTO {
    private Long id;
    private String emailTo;
    private String subject;
    private String text;
}
