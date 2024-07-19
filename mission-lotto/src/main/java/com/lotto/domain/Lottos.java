package com.lotto.domain;

import com.lotto.domain.vo.lottoNumber.LottoNumber;
import com.lotto.domain.vo.lottoNumber.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lottos {

    private final RandomNumberGenerator randomNumberGenerator;

    public Lottos(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public List<Lotto> generateLottos(int ticketCount) {
        List<Lotto> lottos = new ArrayList<>();
        createLottoAsTicket(ticketCount, lottos);
        return lottos;
    }

    private void createLottoAsTicket(final int ticketCount, final List<Lotto> lottos) {
        for (int i = 0; i < ticketCount; i++) {
            Set<Integer> numbers = LottoNumber.generateNumbers(randomNumberGenerator);
            lottos.add(new Lotto(numbers.stream()
                    .sorted()
                    .collect(Collectors.toList())));
        }
    }
}
