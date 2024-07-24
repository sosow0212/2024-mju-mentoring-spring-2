package com.racing.console.view;

import java.util.Scanner;

public class InputView {

    private final Scanner input;

    public InputView(Scanner input) {
        this.input = input;
    }


    public String inputCarNames() {
        return input.next();
    }

    public int inputChance() {
        return input.nextInt();
    }
}
