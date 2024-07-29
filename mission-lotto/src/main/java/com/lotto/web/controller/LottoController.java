package com.lotto.web.controller;

import com.lotto.web.dto.LottoRequest;
import com.lotto.web.service.LottoService;
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

    @PostMapping("/buy")
    public ResponseEntity<Void> buyLottos(@RequestBody LottoRequest lottoRequest){
        lottoService.buyLotto(lottoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
