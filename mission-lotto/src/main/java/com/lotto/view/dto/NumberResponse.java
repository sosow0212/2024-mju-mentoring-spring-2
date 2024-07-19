package com.lotto.view.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberResponse {

    public static final String DISTINCT_COMMA = ",";

    public List<Integer> response(String winNumbers) {
        return Arrays.stream(winNumbers.split(DISTINCT_COMMA))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public List<List<Integer>> getPassiveNumbers(int count, String numbers) {
        List<List<Integer>> passiveNumbers = new ArrayList<>();
        resultPassiveNumber(count, numbers, passiveNumbers);
        return passiveNumbers;
    }

    private static void resultPassiveNumber(final int count, final String numbers, final List<List<Integer>> passiveNumbers) {
        for (int i = 0; i < count; i++) {
            passiveNumbers.add(Arrays.stream(numbers.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList()));
        }
    }

}

