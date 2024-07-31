package com.lotto.web.controller;

import com.lotto.web.dto.LottoRequest;
import com.lotto.web.dto.LottoResponse;
import com.lotto.web.service.LottoService;
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

    @PostMapping("/buy")
    public ResponseEntity<Void> buyLottos(@RequestBody LottoRequest lottoRequest) {
        lottoService.buyLotto(lottoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/user/{id}/lottos")
    public ResponseEntity<List<LottoResponse>> showLottos(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(lottoService.getLottos(id));
    }

    @GetMapping(value = "/user/{id}/lottos", params = "order")
    public ResponseEntity<LottoResponse> showLotto(@PathVariable Long id, @RequestParam("order") int order) {
        return ResponseEntity.status(HttpStatus.OK).body(lottoService.getLotto(id, order));
    }
}
