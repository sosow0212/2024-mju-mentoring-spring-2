package com.lotto.controller.dto;

import lombok.Data;

@Data
public class UserResponse {

    private Long userId;
    private String userName;
    private int balance;

    public UserResponse(Long userId, String userName, int balance) {
        this.userId = userId;
        this.userName = userName;
        this.balance = balance;
    }
}