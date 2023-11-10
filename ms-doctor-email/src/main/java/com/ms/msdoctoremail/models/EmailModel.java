package com.ms.msdoctoremail.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Entity
@Table(name= "TB_EMAILS")
public class EmailModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long emailId;
    private Long userId;
    private String emailFrom;
    private String emailTo;
    @Column(columnDefinition = "TEXT")
    private String text;
    private LocalDateTime sendDateTime;
    private StatusEmail statusEmail;


}
