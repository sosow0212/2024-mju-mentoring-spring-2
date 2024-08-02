package com.lotto.web.service;

import com.lotto.web.domain.CreateRandomNumber;
import com.lotto.web.domain.Lotto;
import com.lotto.web.domain.LottoNumberParser;
import com.lotto.web.domain.LottoRank;
import com.lotto.web.domain.exception.CustomErrorCode;
import com.lotto.web.domain.exception.CustomException;
import com.lotto.web.dto.LottoRequest;
import com.lotto.web.dto.LottoResponse;
import com.lotto.web.entity.LottoAnswer;
import com.lotto.web.entity.LottoEntity;
import com.lotto.web.entity.User;
import com.lotto.web.repository.LottoAnswerRepository;
import com.lotto.web.repository.LottoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LottoService {

    private final CreateRandomNumber createRandomNumber;
    private final UserService userService;
    private final LottoRepository lottoRepository;
    private final LottoAnswerRepository lottoAnswerRepository;

    public LottoService(CreateRandomNumber createRandomNumber, UserService userService, LottoRepository lottoRepository, LottoAnswerRepository lottoAnswerRepository) {
        this.createRandomNumber = createRandomNumber;
        this.userService = userService;
        this.lottoRepository = lottoRepository;
        this.lottoAnswerRepository = lottoAnswerRepository;
    }

    public void buyLotto(LottoRequest lottoRequest) {
        int money = userService.getUserMoney(lottoRequest.userId());
        validateLottoMoney(money, lottoRequest.count());
        LottoAnswer lottoAnswer = getLottoAnswer();
        saveLottos(lottoRequest, lottoAnswer.getLottoAnswer());
        userService.updateMoney(lottoRequest);
    }

    public LottoResponse getLotto(Long id, int order) {
        List<LottoResponse> lottoResponses = getLottos(id);
        validateLottoOrder(lottoResponses, order);
        return lottoResponses.get(order - 1);
    }

    public List<LottoResponse> getLottos(Long id) {
        List<LottoEntity> lottoEntities = lottoRepository.findAllByUserId(id);
        validateLottoExist(lottoEntities);
        List<LottoResponse> lottoResponses = new ArrayList<>();
        for (LottoEntity lottoEntity : lottoEntities) {
            lottoResponses.add(new LottoResponse(lottoEntity.getLottoNumber(), lottoEntity.getWin()));
        }
        return lottoResponses;
    }

    private void saveLottos(LottoRequest lottoRequest, String lottoAnswer) {
        User user = userService.getUser(lottoRequest.userId());
        LottoNumberParser parsedLottoAnswer = new LottoNumberParser(lottoAnswer);
        for (int i = 0; i < lottoRequest.count(); i++) {
            Lotto lotto = new Lotto(createRandomNumber);
            int count = getLottoRank(lotto.getLotto(), parsedLottoAnswer.getLottoNumber());
            LottoEntity lottoEntity = lottoRequest.toLottoEntity(user, lotto.getLotto().toString(), win(count
            ));
            lottoRepository.save(lottoEntity);
            userService.saveWinning(user, count);
        }
    }

    private boolean win(int count){
        return count >= 3;
    }

    private int getLottoRank(List<Integer> lotto, List<Integer> lottoAnswer){
        LottoRank lottoRank = new LottoRank(lotto, lottoAnswer);
        return lottoRank.getCount();
    }

    private LottoAnswer getLottoAnswer(){
        Optional<LottoAnswer> lottoAnswer = lottoAnswerRepository.findFirstByOrderById();
        return lottoAnswer.orElseGet(this::createLottoAnswer);
    }

    private LottoAnswer createLottoAnswer() {
        Lotto lotto = new Lotto(createRandomNumber);
        LottoAnswer lottoAnswer = new LottoAnswer(null, lotto.getLotto().toString());
        lottoAnswerRepository.save(lottoAnswer);
        return lottoAnswer;
    }

    private void validateLottoMoney(int money, int count) {
        if (money < count * 1000) {
            throw new CustomException(CustomErrorCode.EXCEPTION_MONEY);
        }
    }

    private void validateLottoOrder(List<LottoResponse> lottoResponses, int order) {
        if (order < 1 || order > lottoResponses.size()) {
            throw new CustomException(CustomErrorCode.EXCEPTION_LOTTO);
        }
    }

    private void validateLottoExist(List<LottoEntity> lottoEntities) {
        if (lottoEntities.isEmpty()) {
            throw new CustomException(CustomErrorCode.EXCEPTION_LOTTO);
        }
    }
}
