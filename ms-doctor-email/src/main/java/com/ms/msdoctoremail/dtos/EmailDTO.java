package com.ms.msdoctoremail.dtos;

public record EmailDTO(Long id, String emailTo, String subject, String text) {
}
