package com.lotto.service;

import com.lotto.domain.Lotto;
import com.lotto.domain.LottoRank;
import com.lotto.domain.Lottos;
import com.lotto.domain.RandomNumber;
import com.lotto.domain.LottoResult;
import com.lotto.entity.UserLotto;
import com.lotto.exception.InsufficientFundsException;
import com.lotto.exception.NotExistLottoException;
import com.lotto.exception.NotExistUserNameException;
import com.lotto.repository.LottoRepository;
import com.lotto.repository.UserRepository;
import com.lotto.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LottoService {

    private UserRepository userRepository;
    private LottoRepository lottoRepository;
    private RandomNumber randomNumber;

    @Autowired
    public LottoService(UserRepository userRepository, LottoRepository lottoRepository, RandomNumber randomNumber) {
        this.lottoRepository = lottoRepository;
        this.userRepository = userRepository;
        this.randomNumber = randomNumber;
    }

    public void buyLotto(String name, int ticketCount) {
        User user = userRepository.findByUserName(name);
        checkUserName(user == null);

        int price = ticketCount * 1000;
        validateMoney(user, price);
        Lottos lottos = Lottos.buyLotto(ticketCount, randomNumber);

        for (Lotto lotto : lottos.getLottos()) {
            UserLotto userLotto = UserLotto.create(lotto.getLottoNumbers(), user);
            user.addUserLotto(userLotto);
            lottoRepository.save(userLotto);
        }

        user.subtractMoney(price);
        userRepository.save(user);
    }

    private void checkUserName(boolean user) {
        if (user) {
            throw new NotExistUserNameException();
        }
    }

    private void validateMoney(User user, int price) {
        if (user.getMoney() < price) {
            throw new InsufficientFundsException();
        }
    }

    public List<UserLotto> getUserLotto(String name) {
        checkUserName(!userRepository.existsByUserName(name));
        return lottoRepository.findByUser_UserName(name);
    }

    public UserLotto getTargetLottoResult(Long lottoId) {
        return lottoRepository.findByLottoId(lottoId).orElseThrow(() -> new NotExistLottoException());
    }

    public int getUserLottoCount(User user) {
        return user.getUserLotto().size();
    }

    public int calculateTotalPrize(User user, List<Integer> winNumbers) {
        int prizeMoney = 0;
        for (UserLotto userLotto : user.getUserLotto()) {
            LottoRank lottoRank = getLottoRank(userLotto.getLottoNumbers(), winNumbers);
            prizeMoney += lottoRank.getPrize();
        }
        return prizeMoney;
    }

    public LottoRank getLottoRank(List<Integer> userLottoNumbers, List<Integer> winningNumbers) {
        LottoResult result = new LottoResult(userLottoNumbers, winningNumbers);
        return result.getLottoRank();
    }

    public boolean isWinningLotto(List<Integer> userLottoNumbers, List<Integer> winningNumbers) {
        LottoRank lottoRank = getLottoRank(userLottoNumbers, winningNumbers);
        return switch (lottoRank) {
            case FIRST, SECOND, THIRD, FOURTH -> true;
            default -> false;
        };
    }
}
