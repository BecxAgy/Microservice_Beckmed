package com.ms.doctor.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="TB_DOC_ADDRESS")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street; // Logradouro
    private String number; // Número
    private String complement; // Complemento
    private String neighborhood; // Bairro
    private String city; // Cidade
    private String state; // UF
    private String postalCode; // CEP








}

