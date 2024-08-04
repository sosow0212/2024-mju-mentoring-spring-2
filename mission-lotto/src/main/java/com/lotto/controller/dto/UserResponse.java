package com.lotto.controller.dto;

public record UserResponse(
        String name,
        int lottoCount,
        int prizeMoney
) {
}
