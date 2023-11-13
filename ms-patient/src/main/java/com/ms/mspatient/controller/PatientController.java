package com.ms.mspatient.controller;

import com.ms.mspatient.dtos.PatientDTO;
import com.ms.mspatient.models.Patient;
import com.ms.mspatient.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    private PatientService service;

    @GetMapping("/get-all")
    public List<PatientDTO> getAll(){

        return service.getActivePatients();

    } 
    @PostMapping("/create")
    public ResponseEntity<PatientDTO> create(@RequestBody PatientDTO patientDTO){
        Patient patient = patientDTO.toEntity();
        service.createPatient(patient);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(patientDTO);
    }
    
   
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable Long id, @RequestBody PatientDTO patientDTO) {
        //primeiro converto para entity
        Patient PatientUpdate = patientDTO.toEntity();

        //depois verifico se existe no banco com findByID
        Optional<Patient> patientExist = service.findById(id);

        if(patientExist.isEmpty()) return ResponseEntity.notFound().build();

        service.updatePatient(patientExist.get(),patientDTO);
        return ResponseEntity.ok(PatientDTO.fromEntity(patientExist.get()));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.markPatientAsInactive(id);
        return ResponseEntity.noContent().build(); // Retorne uma resposta 204 No Content
    }
}
