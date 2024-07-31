package com.lotto.controller.dto;

import lombok.Data;

@Data
public class BuyRequest {

    private Long userId;
    private int ticketCount;

}
