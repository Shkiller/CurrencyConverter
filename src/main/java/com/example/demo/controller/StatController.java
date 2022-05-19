package com.example.demo.controller;

import com.example.demo.service.StatService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/stats")
@AllArgsConstructor
public class StatController {
    private final StatService statService;

    @GetMapping("/10000")
    public Set<Integer> getStat10000() {
        return statService.getStat10000();
    }

    @GetMapping("/100000")
    public Set<Integer> getStat100000() {
        return statService.getStat100000();
    }

    @GetMapping("/rating")
    public Set<String> getRating() {
        return statService.getRating();
    }
}
