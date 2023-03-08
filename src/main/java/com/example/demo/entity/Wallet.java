package com.example.demo.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class Wallet implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String cardId;      //钱包卡号
    private BigDecimal amount;   //金额
    private Integer userId;
    private String password;
}
