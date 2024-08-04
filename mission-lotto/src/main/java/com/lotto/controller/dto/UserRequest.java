package com.lotto.controller.dto;

public record UserRequest(
        String name,
        int ticketCount
) {
}
