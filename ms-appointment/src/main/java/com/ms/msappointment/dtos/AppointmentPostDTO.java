package com.ms.msappointment.dtos;

import com.ms.msappointment.domain.models.Appointment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentPostDTO {
    private Long fkPatientId;
    private Long fkDoctorId;
    private LocalDateTime date_hour;

    public static AppointmentPostDTO fromEntity(Appointment appointment) {
        ModelMapper modelMapper = new ModelMapper();

        return modelMapper.map(appointment, AppointmentPostDTO.class);

    }

    public Appointment toEntity() {

        Appointment appointment = new Appointment();

        appointment.setFkPatientId(this.getFkPatientId());
        appointment.setFkDoctorId(this.getFkDoctorId());
        appointment.setDateHour(this.getDate_hour());

        return appointment;



    }

}
