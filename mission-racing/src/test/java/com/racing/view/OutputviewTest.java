package com.racing.view;

import org.junit.jupiter.api.Test;

import java.util.List;

class OutputviewTest {

    @Test
    void 최중우승자_출력_테스트() {

        // given
        Outputview outputview = new Outputview();
        List<String> winners = List.of("car1", "car2");

        // when&then
        outputview.printFinalWinner(winners);
    }

}