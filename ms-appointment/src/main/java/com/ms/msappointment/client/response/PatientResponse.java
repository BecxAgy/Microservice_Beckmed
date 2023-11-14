package com.ms.msappointment.client.response;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PatientResponse {
    private Long id;
    private String name;
    private String email;
    private String telefone;
    private String cpf;

}
