package com.lotto.view.dto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumberResponse {

    public static final String DISTINCT_COMMA = ",";

    public List<Integer> response(String winNumbers) {
        return Arrays.stream(winNumbers.split(DISTINCT_COMMA))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}

