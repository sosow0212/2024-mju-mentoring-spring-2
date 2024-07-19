package com.lotto.controller;

import com.lotto.domain.Lotto;
import com.lotto.domain.Lottos;

import com.lotto.domain.vo.lottoNumber.RandomNumberGenerator;

import com.lotto.domain.vo.winLotto.LottoRate;
import com.lotto.domain.vo.winLotto.Ranking;
import com.lotto.domain.vo.winLotto.WinningLotto;

import com.lotto.view.InputView;
import com.lotto.view.OutputView;

import com.lotto.view.dto.LottoDto;
import com.lotto.view.dto.ProcessingRequestMoney;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        int money = inputView.getMoney();
        int manualCount = inputView.getManualCount();
        List<Lotto> manualLottos = inputView.getManualLottoNumbers(manualCount);

        int remainingMoney = ProcessingRequestMoney.calculateRemainingMoney(money, manualCount);
        int autoCount = ProcessingRequestMoney.countTickets(remainingMoney);

        List<Lotto> allLottos = new ArrayList<>(manualLottos);

        Lottos lottos = new Lottos(new RandomNumberGenerator());
        allLottos.addAll(lottos.generateLottos(autoCount));

        List<LottoDto> lottoDtos = new ArrayList<>();
        for (Lotto lotto : allLottos) {
            lottoDtos.add(new LottoDto(lotto.getLotto()));
        }
        resultLotto(lottoDtos, allLottos, money);
    }

    private void resultLotto(final List<LottoDto> lottoDtos, final List<Lotto> allLottos, final int money) {
        outputView.displayLottoTickets(lottoDtos);

        List<Integer> winNumbers = inputView.getWinNumbers();
        int bonusNumber = inputView.getBonusNumber();

        WinningLotto winningLotto = new WinningLotto(winNumbers, bonusNumber);
        LottoRate lottoRate = new LottoRate(allLottos, winningLotto);

        getLotto(allLottos, winningLotto);

        double rateOfReturn = lottoRate.calculateRateOfReturn(money);
        outputView.displayRateOfReturn(rateOfReturn);
    }

    private void getLotto(final List<Lotto> allLottos, final WinningLotto winningLotto) {
        for (Lotto lotto : allLottos) {
            int matchedNumbers = winningLotto.getCount(lotto.getLotto());
            int matchedBonusNumbers = winningLotto.getBonusCount(lotto.getLotto());
            Ranking ranking = Ranking.valueOfCount(matchedNumbers, matchedBonusNumbers);
            outputView.displayWinning(ranking);
        }
    }
}
