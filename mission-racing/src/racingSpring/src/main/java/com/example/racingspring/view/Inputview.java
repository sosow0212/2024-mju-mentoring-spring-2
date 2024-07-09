package com.example.racingspring.view;


import com.example.racingspring.view.exception.NullInputException;

import java.util.Scanner;

public class Inputview {
    private final Scanner scanner = new Scanner(System.in);

    private NullInputException nullInputException;

    public String getMoveCarName() {
        System.out.println("자동차 이름 입력 (쉼표로 구분하여 입력하세요): ");
        String input = scanner.nextLine();
        nameException(input);
        return input;
    }

    private void nameException(final String input) {
        if (input.isBlank()) {
            throw nullInputException;
        }
    }

    public int getChance() {
        System.out.println("시도할 회수는? ");
        return Integer.parseInt(scanner.nextLine());
    }
}
