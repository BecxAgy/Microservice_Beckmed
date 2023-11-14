package com.ms.msappointment.controllers;

import com.ms.msappointment.client.response.DoctorResponse;
import com.ms.msappointment.client.response.PatientResponse;
import com.ms.msappointment.domain.services.DoctorService;
import com.ms.msappointment.domain.services.PatientService;
import com.ms.msappointment.dtos.AppointmentCanceledDTO;
import com.ms.msappointment.dtos.AppointmentPostDTO;
import com.ms.msappointment.domain.models.Appointment;
import com.ms.msappointment.domain.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService service;
    @Autowired
    private PatientService patientService;
    @Autowired
    private DoctorService doctorService;


    @PostMapping("/create")
    public ResponseEntity<AppointmentPostDTO> createAppointment(@RequestBody AppointmentPostDTO appointment) {


//se a clinica stiver fechada
        service.clinicIsClose(appointment.getDate_hour());
        //verificar se o medicoid está ativo e retornar ele
        DoctorResponse doctor = doctorService.getActivePatientById(appointment.getFkDoctorId());

        //verificar se o o patientId esta ativo e retornar ele
        PatientResponse patient = patientService.getActivePatientById(appointment.getFkPatientId());

        //verificar se o médico já possui consulta nessa data e hora
        service.checkIfDoctorHasAppointmentAtDate(appointment.getFkDoctorId(), appointment.getDate_hour());

        //verificar se ela ja possui uma consulta nesse mesmo dia (dia, patientId)
        service.checkIfPatientHasAppointment(appointment.getFkPatientId(), appointment.getDate_hour());

        //verificar se tem antecedencia de 30 min na consulta
        service.isValidAppointment(appointment.getDate_hour());


        Appointment appointmentConvert = appointment.toEntity();

        service.createAppointment(appointmentConvert);
        return new ResponseEntity<>(appointment, HttpStatus.CREATED);


    }

    @PostMapping("/cancel")
    public ResponseEntity<String> cancelAppointment(@RequestBody AppointmentCanceledDTO cancellationDTO) {

            service.cancelAppointment(cancellationDTO.getAppointmentId(), cancellationDTO.getCancellationReason());
            return ResponseEntity.ok("Consulta cancelada com sucesso");

    }


}
