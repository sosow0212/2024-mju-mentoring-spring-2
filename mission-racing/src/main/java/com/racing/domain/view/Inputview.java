package com.racing.domain.view;

import java.util.Scanner;

public class Inputview {
    private final Scanner scanner = new Scanner(System.in);

    public String getMoveCarName() {
        System.out.println("자동차 이름 입력 (쉼표로 구분하여 입력하세요): ");
        return scanner.nextLine();
    }

    public int getChance() {
        System.out.println("시도할 회수는? ");
        return Integer.parseInt(scanner.nextLine());
    }
}
