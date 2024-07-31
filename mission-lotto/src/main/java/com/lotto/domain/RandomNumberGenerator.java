package com.lotto.domain;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class RandomNumberGenerator implements NumberGenerator {

    private static final int MAX = 45;
    private static final int MIN = 1;

    @Override
    public List<Integer> generateRandomNumber() {
        Random random = new Random();
        Set<Integer> numbers = new LinkedHashSet<>();
        while (numbers.size() < 6) {
            numbers.add(random.nextInt(MAX - MIN + 1) + MIN);
        }
        return new ArrayList<>(numbers);
    }
}
