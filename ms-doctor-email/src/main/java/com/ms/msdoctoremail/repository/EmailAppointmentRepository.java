package com.ms.msdoctoremail.repository;

import com.ms.msdoctoremail.models.EmailAppointmentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailAppointmentRepository extends JpaRepository<EmailAppointmentModel, Long> {
}
