package com.example.demo.service;

import com.example.demo.repository.ExchangeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

@Service
@AllArgsConstructor
public class StatService {
    private final ExchangeRepository exchangeRepository;

    public Set<Integer> getStat10000() {
        return exchangeRepository.findAllByValueGreaterThanEqual();
    }

    public Set<Integer> getStat100000() {
        return exchangeRepository.findAllByValue100000();
    }

    public  Set<String> getRating() {
        return exchangeRepository.findAllByToCount();
    }
}
