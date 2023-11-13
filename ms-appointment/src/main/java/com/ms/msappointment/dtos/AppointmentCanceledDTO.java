package com.ms.msappointment.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AppointmentCanceledDTO {
    private Long appointmentId;
    private String cancellationReason;

}
