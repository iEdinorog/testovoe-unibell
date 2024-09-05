package com.testovoeunibell.dto;

import com.testovoeunibell.entity.ContactType;

public record ContactDto(
        Integer clientId,
        String data,
        ContactType type
) {
}
