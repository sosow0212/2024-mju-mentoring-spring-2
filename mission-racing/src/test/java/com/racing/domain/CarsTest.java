package com.racing.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    @Test
    void 자동차_이름_인스턴스_변환_테스트() {

        // given
        Cars cars = Cars.from("poby,crong,dd");

        // when&then
        assertEquals(3, cars.getCarStates().size());
    }

    @Test
    void 우승자_찾기() {
        NumberGenerator fixedNumberGenerator = () -> 4;
        Cars cars = Cars.from("car1,car2,car3");
        cars.moveCars(1, fixedNumberGenerator);

        List<String> winners = cars.findsWinner();
        assertEquals(3, winners.size());
        assertTrue(winners.contains("car1"));
        assertTrue(winners.contains("car2"));
        assertTrue(winners.contains("car3"));
    }


}