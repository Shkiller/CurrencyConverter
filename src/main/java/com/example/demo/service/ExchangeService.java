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

    public ExchangeData exchange(ExchangeRequestData exchangeRequestData) {
        MonetaryAmount monetaryFrom = Monetary.getDefaultAmountFactory().setCurrency(exchangeRequestData.getFrom())
                .setNumber(exchangeRequestData.getValue()).create();
        MonetaryAmount convertedAmount = monetaryFrom.with(MonetaryConversions.getConversion(exchangeRequestData.getTo()));
        MonetaryAmount convertUSD = monetaryFrom.with(MonetaryConversions.getConversion("USD"));
        Exchange exchange = exchangeRepository.save(new Exchange()
                .setFrom(exchangeRequestData.getFrom())
                .setTo(exchangeRequestData.getTo())
                .setUserId(exchangeRequestData.getId())
                .setValue(convertUSD.getNumber().numberValue(BigDecimal.class)));
        return new ExchangeData(exchange.getId(), convertedAmount.getNumber().numberValue(BigDecimal.class));
    }
}
