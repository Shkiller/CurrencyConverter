package com.example.demo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
public class ExchangeData {
    private int id;
    private BigDecimal value;
}
