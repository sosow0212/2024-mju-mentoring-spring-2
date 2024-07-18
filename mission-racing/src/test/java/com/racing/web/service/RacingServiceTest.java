package com.racing.web.service;

import com.racing.common.domain.Car;
import com.racing.common.domain.Cars;
import com.racing.common.domain.CreateRandomNumber;
import com.racing.common.domain.FakeRandomNumber.FakeRandomNumber;
import com.racing.common.domain.exception.CustomException;
import com.racing.common.domain.vo.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class RacingServiceTest {

    @Test
    @DisplayName("차 만들기 서비스 메서드 테스트")
    void createCars() {
        // given
        List<Name> carNames = List.of(new Name("aa"), new Name("bb"), new Name("cc"));
        int expected = 3;

        // when
        int actual = new RacingService().createCars(carNames).getCars().size();

        // then
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("차 만들기 서비스 메서드 테스트_예외처리")
    void createCars_generate_exception() {
        // given
        List<Name> carNames = List.of(new Name("aaaaaa"), new Name("bb"), new Name("cc"));
        var expected = "차 이름 너무 긺";

        // when
        CustomException actual = assertThrows(CustomException.class, () -> new RacingService().createCars(carNames));

        // then
        assertEquals(expected, actual.getMessage());
    }

    @Test
    @DisplayName("차 움직이기 서비스 메서드 테스트")
    void startRace() {
        // given
        List<Name> carNames = List.of(new Name("aa"), new Name("bb"), new Name("cc"));
        Cars cars = new Cars(carNames);
        CreateRandomNumber createRandomNumber = new FakeRandomNumber();
        RacingService racingService = new RacingService();
        int tryCount = 3;
        racingService.startRace(cars, createRandomNumber, tryCount);
        List<Integer> expected = List.of(3, 3, 3);

        // when
        List<Integer> actual = cars.getCars().stream()
                .map(Car::getMoveCount)
                .collect(Collectors.toList());

        // then
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("우승자 + 레이스 결과 반환 받는 메서드")
    void getResult() {
        // given
        RacingService racingService = new RacingService();
        List<String> winner = List.of("bb");
        List<Map<String, Integer>> status = List.of(Map.of("aa", 1), Map.of("bb", 2), Map.of("cc", 1));
        Map<String, Object> expected = Map.of("winner", String.join(",", winner), "status", status);


        // when
        Map<String, Object> actual = racingService.getResult(status, winner);

        // then
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("이름으로 카운트 반환받는 메서드")
    void getResultByName() {
        // given
        RacingService racingService = new RacingService();
        List<Map<String, Integer>> status = List.of(Map.of("aa", 1), Map.of("bb", 2), Map.of("cc", 1));
        Map<String, Integer> expected = Map.of("bb", 2);

        // when
        Map<String, Integer> actual = racingService.getResultByName(status, "bb");

        // then
        assertEquals(expected, actual);

    }
}
