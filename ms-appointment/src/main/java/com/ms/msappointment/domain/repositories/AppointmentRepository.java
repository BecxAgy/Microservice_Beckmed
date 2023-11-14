package com.ms.msappointment.domain.repositories;


import com.ms.msappointment.domain.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Optional;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    @Query("SELECT COUNT(a) FROM Appointment a " +
            "WHERE a.fkPatientId = :patientId " +
            "AND CAST(a.dateHour AS DATE) = CAST(:dateHour AS DATE)")
    long countAppointmentsByPatientAndDate(@Param("patientId") Long patientId, @Param("dateHour") LocalDateTime dateHour);


    @Query("SELECT a FROM Appointment a WHERE a.fkDoctorId = :doctorId " +
            "AND DATE(a.dateHour) = DATE(:startDateTime) " +
            "AND (HOUR(a.dateHour) <= HOUR(:startDateTime) + 1 OR HOUR(:startDateTime) <= HOUR(a.dateHour) + 1)")
    Optional<Appointment> findOverlappingAppointment(
            @Param("doctorId") Long doctorId,
            @Param("startDateTime") LocalDateTime startDateTime

    );

    @Query("SELECT a FROM Appointment a WHERE a.fkDoctorId = :doctorId AND a.dateHour = :dateHour")
    Optional<Appointment> findByDoctorIdAndDateHour(Long doctorId, LocalDateTime dateHour);


        @Query("SELECT a FROM Appointment a WHERE a.fkDoctorId = :doctorId AND a.dateHour BETWEEN :startInterval AND :endInterval")
        Optional<Appointment> findByDoctorIdAndDateHourBetween(Long doctorId, LocalDateTime startInterval, LocalDateTime endInterval);






}
