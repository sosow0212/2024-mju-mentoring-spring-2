package com.lotto.web.service;

import com.lotto.web.domain.CreateRandomNumber;
import com.lotto.web.domain.Lotto;
import com.lotto.web.domain.exception.CustomErrorCode;
import com.lotto.web.domain.exception.CustomException;
import com.lotto.web.dto.LottoRequest;
import com.lotto.web.entity.LottoEntity;
import com.lotto.web.entity.User;
import com.lotto.web.repository.LottoRepository;
import org.springframework.stereotype.Service;

@Service
public class LottoService {

    private final CreateRandomNumber createRandomNumber;
    private final UserService userService;
    private final LottoRepository lottoRepository;

    public LottoService(CreateRandomNumber createRandomNumber, UserService userService, LottoRepository lottoRepository) {
        this.createRandomNumber = createRandomNumber;
        this.userService = userService;
        this.lottoRepository = lottoRepository;
    }

    public void buyLotto(LottoRequest lottoRequest) {
        int money = userService.getUserMoney(lottoRequest.getUserId());
        if (money < lottoRequest.getCount() * 1000) {
            throw new CustomException(CustomErrorCode.EXCEPTION_MONEY);
        }
        saveLottos(lottoRequest);
        userService.buyLotto(lottoRequest);

    }

    private void saveLottos(LottoRequest lottoRequest) {
        User user = userService.getUser(lottoRequest.getUserId());
        for (int i = 0; i < lottoRequest.getCount(); i++) {
            Lotto lotto = new Lotto(createRandomNumber);
            LottoEntity lottoEntity = lottoRequest.toLottoEntity(user, lotto.getLotto().toString());
            lottoRepository.save(lottoEntity);
        }
    }
}
