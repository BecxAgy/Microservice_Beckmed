package com.ms.doctor.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
@Entity
@Table(name = "TB_DOCTORS")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean active ; // Adicione este campo
    private String name;
    private String email;
    private String phone;
    private String crm;
    @Enumerated(EnumType.STRING)
    private Speciality speciality;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;


    public Doctor() {
        this.active = true;

    }
}
