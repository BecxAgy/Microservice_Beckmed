package com.ms.msappointment.repositories;


import com.ms.msappointment.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    @Query("SELECT COUNT(a) FROM Appointment a " +
            "WHERE a.patient.id = :patientId " +
            "AND CAST(a.date_hour AS DATE) = CAST(:dateHour AS DATE)")
    long countAppointmentsByPatientAndDate(@Param("patientId") Long patientId, @Param("dateHour") LocalDateTime dateHour);
}
