package com.lotto.controller.dto;

import lombok.Data;

@Data
public class WinningsResponse {

    private Long userId;
    private String userName;
    private int ticketCount;
    private int totalWinnings;
    private int balance;

    public WinningsResponse(Long userId, String userName, int ticketCount, int totalWinnings, int balance) {
        this.userId = userId;
        this.userName = userName;
        this.ticketCount = ticketCount;
        this.totalWinnings = totalWinnings;
        this.balance = balance;
    }
}
