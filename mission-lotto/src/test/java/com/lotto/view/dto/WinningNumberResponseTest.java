package com.lotto.view.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


class WinningNumberResponseTest {

    @Test
    void 지난주_당첨금_테스트 () {

        // given
        NumberResponse numberResponse = new NumberResponse();

        // when
        List<Integer> expect = numberResponse.response("1,2,3,4,5,6");
        List<Integer> result = List.of(1,2,3,4,5,6);

        // then
        Assertions.assertEquals(result,expect);
    }
}