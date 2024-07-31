package com.lotto.controller;

import com.lotto.controller.dto.BuyRequest;
import com.lotto.controller.dto.WinningsResponse;
import com.lotto.entity.LottoTicket;
import com.lotto.entity.User;
import com.lotto.service.LottoService;
import com.lotto.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/lottos")
public class LottoController {

    @Autowired
    private LottoService lottoService;

    @Autowired
    private UserService userService;

    @PostMapping("/buy")
    public ResponseEntity<Map<String, String>> buyLotto(@RequestBody BuyRequest request) {
        lottoService.buyTickets(request.getUserId(), request.getTicketCount());
        Map<String, String> response = new HashMap<>();
        response.put("message", "구매 완료됨");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/tickets")
    public List<LottoTicket> getTickets(@RequestParam Long userId) {
        User user = userService.findByUserId(userId);
        return lottoService.getTickets(userId);
    }

    @GetMapping("/winnings")
    public WinningsResponse getWinnings(@RequestParam Long userId) {
        User user = userService.findByUserId(userId);
        List<LottoTicket> tickets = lottoService.getTickets(userId);
        int totalWinnings = (int) tickets.stream()
                .filter(LottoTicket::isWinner)
                .count() * 1000;
        return new WinningsResponse(userId, user.getUserName(), tickets.size(), totalWinnings, user.getBalance());
    }
}
