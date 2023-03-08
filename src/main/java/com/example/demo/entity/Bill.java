package com.example.demo.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Bill implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private Integer cardId;    //钱包卡号
    private LocalDateTime create_time;
    private BigDecimal amount;//金额
    private Integer type;    //类型  1.支出 2.存入   3.退款

}
