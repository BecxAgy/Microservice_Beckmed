package com.ms.doctor.repository;


import com.ms.doctor.model.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    List<Doctor> findByActive(boolean active);
    Page<Doctor> findByActive(boolean b, PageRequest pageable);
}
