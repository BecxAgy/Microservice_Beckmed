package com.ms.msappointment.client.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DoctorResponse {
    private Long id;

    private String name;
    private String email;

    private String phone;

    private String crm;

    private Speciality speciality;


}
