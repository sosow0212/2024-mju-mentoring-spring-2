package com.lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    public static final int INITIAL_NUMBER = 0;

    private final List<Lotto> lottos = new ArrayList<>();

    private final NumberGenerator numberGenerator;

    public Lottos(final NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public List<Lotto> generateLottoTickets(int ticketCount) {
        for (int i = INITIAL_NUMBER; i < ticketCount; i++) {
            List<Integer> numbers = numberGenerator.generateRandomNumber();
            Lotto ticket = new Lotto(numbers);
            lottos.add(ticket);
        }
        return lottos;
    }

}
