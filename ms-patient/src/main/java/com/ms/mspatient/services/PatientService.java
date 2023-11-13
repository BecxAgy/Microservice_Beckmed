package com.ms.mspatient.services;


import com.ms.mspatient.dtos.PatientDTO;
import com.ms.mspatient.exceptions.PatientInactiveException;
import com.ms.mspatient.exceptions.PatientNotFoundException;
import com.ms.mspatient.models.Address;
import com.ms.mspatient.models.Patient;
import com.ms.mspatient.producers.PatientProducer;
import com.ms.mspatient.repositories.PatientRespository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PatientService {
    @Autowired
    private PatientRespository repository;

    @Autowired
    private PatientProducer patientProducer;
    @Autowired
    private AddressService addressService;

    public List<PatientDTO> convertList(List<Patient> list){

        return list.stream().map(PatientDTO :: fromEntity).collect(Collectors.toList());
    }

    public List<PatientDTO> searchAll(){
        return  this.convertList(this.repository.findAll());
    }

    public List<PatientDTO> getActivePatients() {
        return this.convertList(repository.findByActive(true));
    }
    @Transactional
    public Patient createPatient(Patient patient) {
        //create Adress
        Address patientAddress = patient.getAddress();
        patientAddress = addressService.saveAddress(patientAddress);
        patient.getAddress().setId(patientAddress.getId());
        patient =  repository.save(patient);

        patientProducer.publishMessageEmail(patient);
        return patient;
    }

    public Optional<Patient> findById(Long id){

        Optional<Patient> patientExist=  repository.findById(id);

        if (patientExist.isEmpty()) {
            throw new PatientNotFoundException("Paciente não encontrado com o id: " + id);
        }

        return patientExist;
    }

    public Patient getPatientActiveById(Long id){
        Optional<Patient> patientExist =  this.findById(id);

        if(!patientExist.get().isActive()) throw new PatientInactiveException("Esse paciente encontra-se inativo");

        return patientExist.get();
    }
    public Patient updatePatient(Patient updatedPatient, PatientDTO updatedData) {

        updatedPatient.setName(updatedData.getName());
        updatedPatient.setTelefone(updatedData.getTelefone());

        updatedPatient.setAddress(addressService.updateAddress(updatedPatient.getAddress(), updatedData.getAddress()));

        return repository.save(updatedPatient);
    }

    public void markPatientAsInactive(Long id) {
        Optional<Patient> optionalPatient = repository.findById(id);

        if (optionalPatient.isPresent()) {
            Patient doctor = optionalPatient.get();
            doctor.setActive(false); // Marque o médico como inativo
            repository.save(doctor); // Atualize o estado no banco de dados
        } else {
            throw new IllegalArgumentException("Paciente não encontrado.");
        }
    }
}
