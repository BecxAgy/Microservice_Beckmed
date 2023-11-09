package com.ms.msdoctoremail.dtos;

public record EmailDoctorDTO(Long doctorId, String emailTo,String subject, String text) {
}
