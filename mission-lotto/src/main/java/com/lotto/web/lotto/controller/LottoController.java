package com.lotto.web.lotto.controller;

import com.lotto.web.lotto.dto.LottoRequest;
import com.lotto.web.lotto.dto.LottoResponse;
import com.lotto.web.lotto.dto.LottoResponses;
import com.lotto.web.lotto.service.LottoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/members/{memberId}/lottos")
    public ResponseEntity<LottoResponses> showLottos(@PathVariable Long memberId) {
        return ResponseEntity.status(HttpStatus.OK).body(lottoService.getLottos(memberId));
    }

    @GetMapping(value = "/members/{memberId}/lottos", params = "order")
    public ResponseEntity<LottoResponse> showLotto(@PathVariable Long memberId, @RequestParam("order") int order) {
        return ResponseEntity.status(HttpStatus.OK).body(lottoService.getLotto(memberId, order));
    }
}
