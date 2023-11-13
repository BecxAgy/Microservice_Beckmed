package com.ms.msappointment.services;

import com.ms.msappointment.exceptions.*;
import com.ms.msappointment.models.Appointment;
import com.ms.msappointment.models.Status;
import com.ms.msappointment.repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;


    public Appointment createAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public void clinicIsClose(LocalDateTime dateHour) {
        // Obtenha o dia da semana da data/hora
        Calendar cal = Calendar.getInstance();
        Instant instant = dateHour.atZone(java.time.ZoneId.systemDefault()).toInstant();
        // Converter Instant para Date
        Date date = Date.from(instant);
        cal.setTime(date);
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

        // Verifique se a clínica está fechada nos fins de semana (sábado e domingo) ou fora do horário de funcionamento
        if (dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY || cal.get(Calendar.HOUR_OF_DAY) < 7 || cal.get(Calendar.HOUR_OF_DAY) >= 19) {
            throw new ClinicOutOfOperationException("A clínica está fechada!");
        }
    }
    public void checkIfPatientHasAppointment(Long patientId, LocalDateTime dateHour) {
        long existingAppointments = appointmentRepository.countAppointmentsByPatientAndDate(patientId, dateHour);

        if (existingAppointments > 0) {
            throw new PatientAlreadyHasAppointmentException("O paciente já possui uma consulta na mesma data!");
        }
    }

    public void isValidAppointment(LocalDateTime dateHour) {
        LocalDateTime now = LocalDateTime.now();

        if(now.plusMinutes(30).isAfter(dateHour)) throw new InvalidAppointmentException("A consulta deve ser agendada com 30 min de antecedência");
    }

    public Appointment findById(Long appointmentId){
        Optional<Appointment> appointment = appointmentRepository.findById(appointmentId);
        if(appointment.isEmpty()) throw new AppointmentNotFoundException("A consulta não foi encontrada!");

        return appointment.get();

    }

    public void cancelAppointment(Long appointmentId, String cancellationReason) {
        Appointment appointment = this.findById(appointmentId);

        // Verifica se a consulta pode ser cancelada com antecedência mínima de 24 horas
        LocalDateTime now = LocalDateTime.now();
        if (appointment.getDateHour().isBefore(now.plusHours(24))) {
            throw new InvalidCancelationException("A consulta não pode ser cancelada com menos de 24 horas de antecedência");
        }

        // Preenche as informações de cancelamento
        appointment.setStatus(Status.CANCELED);
        appointment.setCancellationReason(cancellationReason);

        // Salva as alterações
        appointmentRepository.save(appointment);
    }




}