package com.lotto.controller.dto;

import java.util.List;

public record AllResultsResponse(
        List<UserResponse> userResults
) {
}
