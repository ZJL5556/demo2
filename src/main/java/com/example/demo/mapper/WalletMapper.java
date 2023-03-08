package com.example.demo.mapper;

import com.example.demo.entity.Bill;
import com.example.demo.entity.Wallet;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface WalletMapper {
    Wallet query(Integer cardId);

    Integer spend(@Param("num")BigDecimal amount, Integer cardId);

    Integer back(@Param("num")BigDecimal amount,Integer cardId);

    List<Bill> bill(Integer cardId);

    Integer addBill(BigDecimal amount, Integer cardId,Integer type);
}
