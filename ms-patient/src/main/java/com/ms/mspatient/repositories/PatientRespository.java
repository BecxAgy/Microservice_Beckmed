package com.ms.mspatient.repositories;

import com.ms.mspatient.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRespository extends JpaRepository<Patient, Long> {
    List<Patient> findByActive(boolean active);

}