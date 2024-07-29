package com.racing.service.dto;


public record CarRegisterRequest(
        String name,
        int tryCount
) {
}
