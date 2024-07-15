package com.racing.common.domain.vo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoveCountTest {

    @Test
    void 숫자4이상일떄_테스트() {

        // given
        MoveCount moveCount = new MoveCount();
        int number = 5;

        // when
        moveCount.move(number);

        // then
        assertEquals(moveCount.getMoveCount(), 1);
    }

    @Test
    void 숫자4미만일떄_테스트() {

        // given
        MoveCount moveCount = new MoveCount();
        int number = 3;

        // when
        moveCount.move(number);

        // then
        assertNotEquals(moveCount.getMoveCount(), 1);
    }
}