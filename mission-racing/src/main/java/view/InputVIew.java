package view;

import java.util.Scanner;

public class InputVIew {

    private final Scanner input = new Scanner(System.in);

    public String inputCarNames() {
        return input.next();
    }

    public int inputChance() {
        return input.nextInt();
    }
}
