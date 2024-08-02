package com.lotto.domain;

import com.lotto.service.infrastructure.vo.RandomNumberGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RandomNumberGeneratorTest {

    @Test
    void 로또생성테스트() {

        // given
        RandomNumberGenerator rng = new RandomNumberGenerator(random);
        List<Integer> numbers = rng.generateRandomNumber();

        // when

        for (Integer number : numbers) {
            assertTrue(number >= 1 && number <= 45);
        }

        // then
        assertTrue(numbers.size() == 6);
    }
}