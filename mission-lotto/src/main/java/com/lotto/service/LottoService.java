package com.lotto.service;

import com.lotto.entity.LottoTicket;
import com.lotto.entity.User;
import com.lotto.repository.LottoTicketRepository;
import com.lotto.repository.UserRepository;
import com.lotto.service.exception.InsufficientBalanceException;
import com.lotto.service.exception.NotFoundUserException;
import com.lotto.service.infrastructure.vo.Lotto;
import com.lotto.service.infrastructure.vo.RandomNumberGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class LottoService {

    private static final int TICKET_PRICE = 1000;

    @Autowired
    private LottoTicketRepository lottoTicketRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RandomNumberGenerator randomNumberGenerator;

    @Transactional
    public List<LottoTicket> buyTickets(Long userId, int ticketCount) {
        User user = userRepository.findById(userId).orElseThrow(NotFoundUserException::new);
        if (user.getBalance() < ticketCount * TICKET_PRICE) {
            throw new InsufficientBalanceException();
        }

        List<LottoTicket> tickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            Lotto lotto = Lotto.from(randomNumberGenerator);
            LottoTicket ticket = new LottoTicket();
            ticket.setUser(user);
            ticket.setNumbers(String.join(",", lotto.getNumbers().stream().map(String::valueOf).toArray(String[]::new)));
            ticket.setWinner(false);
            tickets.add(lottoTicketRepository.save(ticket));
        }

        user.setBalance(user.getBalance() - ticketCount * TICKET_PRICE);
        userRepository.save(user);

        return tickets;
    }

    public List<LottoTicket> getTicketsByUserId(Long userId) {
        return lottoTicketRepository.findByUserUsrId(userId);
    }

    public int getTotalWinnings(Long userId) {
        List<LottoTicket> tickets = lottoTicketRepository.findByUserUsrId(userId);
        return (int) tickets.stream().filter(LottoTicket::isWinner).count() * 1000000;
    }
}
