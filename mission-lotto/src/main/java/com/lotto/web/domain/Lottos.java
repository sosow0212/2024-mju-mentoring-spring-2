package com.lotto.web.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private static final int INITIAL_NUMBER = 0;

    private final List<Lotto> lottos;

    public Lottos(CreateRandomNumber createRandomNumber, int count) {
        this.lottos = makeLottos(createRandomNumber, count);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }

    private List<Lotto> makeLottos(CreateRandomNumber createRandomNumber, int count) {
        List<Lotto> lottoBundle = new ArrayList<>();
        for (int i = INITIAL_NUMBER; i < count; i++) {
            lottoBundle.add(new Lotto(createRandomNumber));
        }
        return lottoBundle;
    }
}
