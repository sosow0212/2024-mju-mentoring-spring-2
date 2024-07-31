package com.lotto.service;

import com.lotto.domain.Lotto;
import com.lotto.domain.Lottos;
import com.lotto.domain.RandomNumberGenerator;
import com.lotto.entity.LottoTicket;
import com.lotto.entity.User;
import com.lotto.repository.LottoTicketRepository;
import com.lotto.repository.UserRepository;
import com.lotto.service.exception.NotEnoughMoneyException;
import com.lotto.service.exception.NotFoundUserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LottoService {

    @Autowired
    private LottoTicketRepository lottoTicketRepository;

    @Autowired
    private UserRepository userRepository;

    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    public void buyTickets(Long userId, int ticketCount) {
        User user = userRepository.findById(userId).orElseThrow(NotFoundUserException::new);
        validateNotEnoughMoney(ticketCount, user);
        Lottos lottos = new Lottos(randomNumberGenerator);
        List<Lotto> generateLottos = lottos.generateLottoTickets(ticketCount);
        settingLottos(generateLottos, user);
        user.setBalance(user.getBalance() - ticketCount * 1000);
        userRepository.save(user);
    }

    private void settingLottos(final List<Lotto> generateLottos, final User user) {
        for (Lotto lotto : generateLottos) {
            LottoTicket ticket = new LottoTicket(user.getUserId(), user.getUserName(), lotto.lotto(), false);
            lottoTicketRepository.save(ticket);
        }
    }

    public List<LottoTicket> getTickets(Long userId) {
        return lottoTicketRepository.findByUserId(userId);
    }

    private static void validateNotEnoughMoney(final int ticketCount, final User user) {
        if (user.getBalance() < ticketCount * 1000) {
            throw new NotEnoughMoneyException();
        }
    }
}
