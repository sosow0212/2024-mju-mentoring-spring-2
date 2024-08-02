package com.lotto.controller;

import com.lotto.controller.dto.BuyTicketRequest;
import com.lotto.controller.dto.UserWinningsResponse;
import com.lotto.entity.LottoTicket;
import com.lotto.entity.User;
import com.lotto.service.LottoService;
import com.lotto.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lottos")
public class LottoController {

    @Autowired
    private LottoService lottoService;

    @Autowired
    private UserService userService;

    @PostMapping("/buy")
    public ResponseEntity<?> buyTickets(@RequestBody BuyTicketRequest request) {
        try {
            return ResponseEntity.ok(lottoService.buyTickets(request.getUserId(), request.getTicketCount()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/tickets")
    public ResponseEntity<List<LottoTicket>> getTickets(@RequestParam Long userId) {
        return ResponseEntity.ok(lottoService.getTicketsByUserId(userId));
    }

    @GetMapping("/winnings")
    public ResponseEntity<UserWinningsResponse> getWinnings(@RequestParam Long userId) {
        int totalWinnings = lottoService.getTotalWinnings(userId);
        User user = userService.getUserById(userId);
        return ResponseEntity.ok(new UserWinningsResponse(userId, user.getUserName(), totalWinnings));
    }
}
