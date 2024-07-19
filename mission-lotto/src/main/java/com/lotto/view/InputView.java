package com.lotto.view;

import com.lotto.domain.Lotto;
import com.lotto.view.dto.NumberResponse;
import com.lotto.view.dto.LottoDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private final NumberResponse numberResponse = new NumberResponse();

    private final Scanner scanner = new Scanner(System.in);

    public int getMoney() {
        System.out.println("금액을 입력하세요:");
        return scanner.nextInt();
    }

    public int getManualCount() {
        System.out.println("수동으로 구매할 로또 수를 입력하시오:");
        return scanner.nextInt();
    }

    public List<Integer> getWinNumbers() {
        System.out.println("지난 주 당첨 번호를 입력하시오 (쉼표로 구분):");
        return numberResponse.response(scanner.next());
    }

    public int getBonusNumber() {
        System.out.println("보너스 볼을 입력하세요:");
        return scanner.nextInt();
    }

    public List<Lotto> getManualLottoNumbers(int count) {
        List<Lotto> manualLottos = new ArrayList<>();
        System.out.println("수동으로 구매할 로또 번호를 입력하세요 (쉼표로 구분):");
        scanner.nextLine();
        passiveLottoDto(count, manualLottos);
        return manualLottos;
    }

    private void passiveLottoDto(final int count, final List<Lotto> manualLottos) {
        for (int i = 0; i < count; i++) {
            System.out.printf("수동 로또 #%d: ", i + 1);
            List<Integer> numbers = numberResponse.response(scanner.nextLine());
            manualLottos.add(new Lotto(numbers));
        }
    }
}
