package com.lotto.service.infrastructure.vo;


import com.lotto.service.infrastructure.vo.exception.BoundaryException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class Lotto {

    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Lotto from(RandomNumberGenerator randomNumberGenerator){
        return new Lotto(createLotto(randomNumberGenerator));
    }

    private static List<Integer> createLotto(final RandomNumberGenerator randomNumberGenerator) {
        Set<Integer> lottoTicket = new HashSet<>();
        while (lottoTicket.size() < 6) {
            int number = randomNumberGenerator.randomNumber();
            validateNumberRange(number);
            lottoTicket.add(number);
        }
        return new ArrayList<>(lottoTicket);
    }

    private static void validateNumberRange(final int number) {
        if(number < 1 || number > 45){
            throw new BoundaryException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}