package com.ms.msdoctoremail.repository;

import com.ms.msdoctoremail.models.EmailModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<EmailModel, Long> {
}
