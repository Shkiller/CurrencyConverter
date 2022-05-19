package com.example.demo.dto.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ExchangeRequestData {
    private String from;
    private String to;
    private BigDecimal value;
    private int id;
}
