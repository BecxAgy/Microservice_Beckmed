package com.ms.msappointment.domain.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="TB_APPOINTMENTS")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_id")
    private Long id;
    private Long fkDoctorId;
    private Long fkPatientId;
    private LocalDateTime dateHour;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String cancellationReason;
}
