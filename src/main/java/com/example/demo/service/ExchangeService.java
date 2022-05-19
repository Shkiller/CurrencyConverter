package com.example.demo.service;

import com.example.demo.dto.request.ExchangeRequestData;
import com.example.demo.entity.Exchange;
import com.example.demo.repository.ExchangeRepository;
import com.example.demo.dto.response.ExchangeData;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.convert.MonetaryConversions;
import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class ExchangeService {
    private final ExchangeRepository exchangeRepository;

    public ExchangeData getExchange(ExchangeRequestData exchangeRequestData) {
        MonetaryAmount monetaryFrom = Monetary.getDefaultAmountFactory().setCurrency(exchangeRequestData.getFrom())
                .setNumber(exchangeRequestData.getValue()).create();
        MonetaryAmount convertedAmount = monetaryFrom.with(MonetaryConversions.getConversion(exchangeRequestData.getTo()));
        Exchange exchange = exchangeRepository.save(new Exchange()
                .setFrom(exchangeRequestData.getFrom())
                .setTo(exchangeRequestData.getTo())
                .setId(exchangeRequestData.getId())
                .setValue(exchangeRequestData.getValue()));
        return new ExchangeData(exchange.getId(), convertedAmount.getNumber().numberValue(BigDecimal.class));
    }
}
