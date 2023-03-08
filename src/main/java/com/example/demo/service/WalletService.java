package com.example.demo.service;

import com.example.demo.dto.Result;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


public interface WalletService {
    Result billList(Integer cardId);

    Result query(Integer userId);

    Result consume(BigDecimal amount,Integer cardId);

    Result back(BigDecimal amount, Integer cardId);
}
