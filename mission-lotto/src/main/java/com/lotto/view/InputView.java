package com.lotto.view;


import com.lotto.view.dto.ProcessingRequestMoney;
import com.lotto.view.dto.WinningNumberResponse;

import java.util.List;
import java.util.Scanner;

public class InputView {


    private WinningNumberResponse winningNumberResponse;

    private ProcessingRequestMoney processingRequestMoney;

    private final Scanner scanner = new Scanner(System.in);

    public int getTicketCount() {
        System.out.println("금액을 입력하세요:");
        int money = scanner.nextInt();
        return processingRequestMoney.count(money);
    }

    public List<Integer> getWinNumbers() {
        System.out.println("지난 주 당첨 번호를 입력하시오 (쉼표로 구분):");
        String winNumbers = scanner.next();
        return winningNumberResponse.response(winNumbers);
    }
}

