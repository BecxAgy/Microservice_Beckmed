package com.ms.msdoctoremail.dtos;

public record EmailDTO(Long doctorId, String emailTo, String subject, String text) {
}
