package com.lotto.web.lotto.controller;

import com.lotto.web.lotto.dto.LottoRequest;
import com.lotto.web.lotto.dto.LottoResponse;
import com.lotto.web.lotto.service.LottoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    @PostMapping("/lottos")
    public ResponseEntity<Void> buyLottos(@RequestBody LottoRequest lottoRequest) {
        lottoService.buyLotto(lottoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/users/{userId}/lottos")
    public ResponseEntity<List<LottoResponse>> showLottos(@PathVariable Long userId) {
        return ResponseEntity.status(HttpStatus.OK).body(lottoService.getLottos(userId));
    }

    @GetMapping(value = "/users/{userId}/lottos", params = "order")
    public ResponseEntity<LottoResponse> showLotto(@PathVariable Long userId, @RequestParam("order") int order) {
        return ResponseEntity.status(HttpStatus.OK).body(lottoService.getLotto(userId, order));
    }
}
