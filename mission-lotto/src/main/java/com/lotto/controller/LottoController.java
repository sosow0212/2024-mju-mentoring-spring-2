package com.lotto.controller;

import com.lotto.controller.dto.AllResultsResponse;
import com.lotto.controller.dto.RegisterRequest;
import com.lotto.controller.dto.UserRequest;
import com.lotto.controller.dto.UserResultResponse;
import com.lotto.controller.dto.UserResponse;
import com.lotto.entity.User;
import com.lotto.entity.UserLotto;
import com.lotto.service.LottoService;
import com.lotto.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api/lotto")
@RestController
public class LottoController {

    private final LottoService lottoService;
    private final UserService userService;

    @Autowired
    public LottoController(LottoService lottoService, UserService userService) {
        this.lottoService = lottoService;
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<Void> registerUser(@RequestBody RegisterRequest registerRequest) {
        userService.registerUser(registerRequest);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/buy")
    public ResponseEntity<Void> buyLotto(@RequestBody UserRequest userRequest) {
        lottoService.buyLotto(userRequest.name(), userRequest.ticketCount());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/result")
    public ResponseEntity<List<UserResultResponse>> getLottoResult(@RequestParam(name = "name") String name, @RequestParam(name = "winNumbers") List<Integer> winNumbers) {
        List<UserLotto> userLottos = lottoService.getUserLotto(name);
        List<UserResultResponse> resultResponses = new ArrayList<>();
        for (UserLotto userLotto : userLottos) {
            boolean isWinning = lottoService.isWinningLotto(userLotto.getLottoNumbers(), winNumbers);
            UserResultResponse response = new UserResultResponse(userLotto.getLottoNumbers(), isWinning);
            resultResponses.add(response);
        }
        return ResponseEntity.ok(resultResponses);
    }

    @GetMapping("/result/{lottoId}")
    public ResponseEntity<UserResultResponse> getTargetLottoResult(@PathVariable(name = "lottoId") Long lottoId, @RequestParam(name = "winNumbers") List<Integer> winNumbers) {
        UserLotto userLotto = lottoService.getTargetLottoResult(lottoId);
        boolean isWinning = lottoService.isWinningLotto(userLotto.getLottoNumbers(), winNumbers);
        UserResultResponse userResultResponse = new UserResultResponse(userLotto.getLottoNumbers(), isWinning);
        return ResponseEntity.ok(userResultResponse);
    }

    @GetMapping("/allResults")
    public ResponseEntity<AllResultsResponse> getAllResults(@RequestParam(name = "winNumbers") List<Integer> winNumbers) {
        List<User> users = userService.getAllUsers();
        List<UserResponse> userResults = new ArrayList<>();
        for (User user : users) {
            int lottoCount = lottoService.getUserLottoCount(user);
            int prizeMoney = lottoService.calculateTotalPrize(user, winNumbers);
            userResults.add(new UserResponse(user.getUserName(), lottoCount, prizeMoney));
        }
        return ResponseEntity.ok(new AllResultsResponse(userResults));
    }
}
