package com.lotto.web.lotto.service;

import com.lotto.web.lotto.domain.CreateRandomNumber;
import com.lotto.web.lotto.domain.Lotto;
import com.lotto.web.lotto.domain.LottoNumberParser;
import com.lotto.web.lotto.domain.LottoRank;
import com.lotto.web.lotto.service.exception.NotFoundLottoException;
import com.lotto.web.lotto.dto.LottoRequest;
import com.lotto.web.lotto.dto.LottoResponse;
import com.lotto.web.lotto.entity.LottoAnswer;
import com.lotto.web.lotto.entity.LottoEntity;
import com.lotto.web.member.entity.Member;
import com.lotto.web.member.service.exception.NotFoundMoneyException;
import com.lotto.web.member.service.MemberService;
import com.lotto.web.lotto.repository.LottoAnswerRepository;
import com.lotto.web.lotto.repository.LottoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LottoService {

    private final CreateRandomNumber createRandomNumber;
    private final MemberService memberService;
    private final LottoRepository lottoRepository;
    private final LottoAnswerRepository lottoAnswerRepository;

    public LottoService(CreateRandomNumber createRandomNumber, MemberService memberService, LottoRepository lottoRepository, LottoAnswerRepository lottoAnswerRepository) {
        this.createRandomNumber = createRandomNumber;
        this.memberService = memberService;
        this.lottoRepository = lottoRepository;
        this.lottoAnswerRepository = lottoAnswerRepository;
    }

    public void buyLotto(LottoRequest lottoRequest) {
        int money = memberService.getUserMoney(lottoRequest.userId());
        validateLottoMoney(money, lottoRequest.count());
        LottoAnswer lottoAnswer = getLottoAnswer();
        saveLottos(lottoRequest, lottoAnswer.getLottoAnswer());
        memberService.updateMoney(lottoRequest);
    }

    public LottoResponse getLotto(Long id, int order) {
        List<LottoResponse> lottoResponses = getLottos(id);
        validateLottoOrder(lottoResponses, order);
        return lottoResponses.get(order - 1);
    }

    public List<LottoResponse> getLottos(Long id) {
        List<LottoEntity> lottoEntities = lottoRepository.findAllByMemberId(id);
        validateLottoExist(lottoEntities);
        List<LottoResponse> lottoResponses = new ArrayList<>();
        for (LottoEntity lottoEntity : lottoEntities) {
            lottoResponses.add(new LottoResponse(lottoEntity.getLottoNumber(), lottoEntity.getWin()));
        }
        return lottoResponses;
    }

    private void saveLottos(LottoRequest lottoRequest, String lottoAnswer) {
        Member member = memberService.getUser(lottoRequest.userId());
        LottoNumberParser parsedLottoAnswer = new LottoNumberParser(lottoAnswer);
        for (int i = 0; i < lottoRequest.count(); i++) {
            Lotto lotto = new Lotto(createRandomNumber);
            int count = getLottoRank(lotto.getLotto(), parsedLottoAnswer.getLottoNumber());
            LottoEntity lottoEntity = lottoRequest.toLottoEntity(member, lotto.getLotto().toString(), win(count
            ));
            lottoRepository.save(lottoEntity);
            memberService.saveWinning(member, count);
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
            throw new NotFoundMoneyException();
        }
    }

    private void validateLottoOrder(List<LottoResponse> lottoResponses, int order) {
        if (order < 1 || order > lottoResponses.size()) {
            throw new NotFoundLottoException();
        }
    }

    private void validateLottoExist(List<LottoEntity> lottoEntities) {
        if (lottoEntities.isEmpty()) {
            throw new NotFoundLottoException();
        }
    }
}
