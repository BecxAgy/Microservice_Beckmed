package com.ms.msappointment.models;

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
@Table(name="appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "appointment_id")
    private Long id;
    private Long fkDoctorId;
    private Long fkPatientId;
    private LocalDateTime dateHour;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String cancellationReason;
}
