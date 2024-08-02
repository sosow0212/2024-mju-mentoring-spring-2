package com.lotto.controller.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserWinningsResponse {

    private final Long userId;
    private final String userName;
    private final int totalWinnings;

}
