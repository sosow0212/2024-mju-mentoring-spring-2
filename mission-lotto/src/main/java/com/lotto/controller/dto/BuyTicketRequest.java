package com.lotto.controller.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class BuyTicketRequest {

    private final Long userId;
    private final int ticketCount;

}
