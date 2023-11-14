package com.ms.msappointment.domain.services;

import com.ms.msappointment.client.PatientClient;
import com.ms.msappointment.client.response.PatientResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    @Autowired
    private PatientClient patientService;

    public PatientResponse getActivePatientById(Long id){
        return patientService.getActivePatientById(id);
    }

}
