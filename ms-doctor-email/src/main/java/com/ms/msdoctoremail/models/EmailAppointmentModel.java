package com.ms.msdoctoremail.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Entity
@Table(name= "TB_EMAILS_APPOINTMENTS")
public class EmailAppointmentModel {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long emailId;
        private String emailDoctorTo;
        private String emailPatientTo;
        private String emailFrom;
        private String subject;
        @Column(columnDefinition = "TEXT")
        private String text;
        private LocalDateTime sendDateTime;
        private StatusEmail statusEmail;
}
