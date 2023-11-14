package com.ms.msappointment.client;

import com.ms.msappointment.client.response.PatientResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name="PatientClient", url = "http://localhost:8383/patient")
public interface PatientClient {
    @GetMapping(value = "/get-active/{id}")
    PatientResponse getActivePatientById(@PathVariable("id") Long id);
}
