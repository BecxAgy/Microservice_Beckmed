package com.ms.msappointment.domain.services;

import com.ms.msappointment.client.DoctorClient;
import com.ms.msappointment.client.response.DoctorResponse;
import com.ms.msappointment.client.response.PatientResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
    @Autowired
    private DoctorClient doctorClient;

    public DoctorResponse getActivePatientById(Long id){
        return doctorClient.getActiveDoctorById(id);
    }
}
