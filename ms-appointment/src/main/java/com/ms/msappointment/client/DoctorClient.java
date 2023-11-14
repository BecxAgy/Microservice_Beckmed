package com.ms.msappointment.client;

import com.ms.msappointment.client.response.DoctorResponse;
import com.ms.msappointment.client.response.PatientResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="DoctorClient", url = "http://localhost:8484/doctor")
public interface DoctorClient {
    @GetMapping(value = "/active/{id}")
    DoctorResponse getActiveDoctorById(@PathVariable("id") Long id);
}