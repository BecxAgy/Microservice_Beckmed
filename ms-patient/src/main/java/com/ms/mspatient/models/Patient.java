package com.ms.mspatient.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean active ; // Adicione este campo
    private String name;
    private String email;
    private String telefone;
    private String cpf;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;


    public Patient(){
        this.active = true;
    }
}
