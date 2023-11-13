package com.ms.msappointment.dtos;

import com.ms.msappointment.models.Appointment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.sql.Timestamp;
import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentPostDTO {
    private Long fkPatientId;
    private Long FkDoctorId;
    private LocalDateTime date_hour;

    public static AppointmentPostDTO fromEntity(Appointment appointment) {
        ModelMapper modelMapper = new ModelMapper();

        return modelMapper.map(appointment, AppointmentPostDTO.class);

    }

    public Appointment toEntity() {
        ModelMapper modelMapper = new ModelMapper();

        return modelMapper.map(this, Appointment.class);
    }

}
