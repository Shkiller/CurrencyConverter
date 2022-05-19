package com.example.demo.controller;

import com.example.demo.dto.request.ExchangeRequestData;
import com.example.demo.dto.response.ExchangeData;
import com.example.demo.service.ExchangeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
public class ExchangeController {
    private final ExchangeService exchangeService;

    @PostMapping("/api/exchange/")
    public ExchangeData exchange(@RequestBody ExchangeRequestData exchangeRequestData) {
        return exchangeService.getExchange(exchangeRequestData);
    }
}
