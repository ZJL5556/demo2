package com.example.demo.service.impl;

import com.example.demo.dto.Result;
import com.example.demo.entity.Bill;
import com.example.demo.entity.Wallet;
import com.example.demo.mapper.WalletMapper;
import com.example.demo.service.WalletService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Service
public class WalletServiceImpl implements WalletService {
    @Resource
    WalletMapper walletMapper;

    //1 支出
    private static final Integer Type_CONSUME = 1;

    //2.存入
    private static final Integer Type_DEPOSIT  = 2;

    //3退款
    private static final Integer Type_BACK = 3;

    /**
     * 查询余额
     * @param cardId
     * @return
     */
    @Override
    public Result query(Integer cardId) {
        return  Result.ok(walletMapper.query(cardId));
    }

    /**
     * 消费
     * @param amount
     * @param cardId
     * @return
     */
    @Override
    public Result consume(BigDecimal amount,Integer cardId) {
        Wallet wallet=walletMapper.query(cardId);
        if(amount.compareTo(wallet.getAmount()) == 1 ){
            return Result.fail("金额不足");
        }
        //消费
        walletMapper.spend(amount,cardId);
        //添加钱包账单明细    Type_CONSUME 1 支出
        walletMapper.addBill(amount,cardId,Type_CONSUME);
        return  Result.ok();
    }

    /**
     * 退款
     * @param amount
     * @param cardId
     * @return
     */
    @Override
    public Result back(BigDecimal amount, Integer cardId) {
        //退款
        walletMapper.back(amount,cardId);
        //添加钱包账单明细    type 3 退款
        walletMapper.addBill(amount,cardId,Type_BACK);
        return Result.ok();
    }

    /**
     * 查询钱包明细
     * @param cardId
     * @return
     */
    @Override
    public Result billList(Integer cardId) {
        return Result.ok(walletMapper.bill(cardId));
    }

    /**
     * 添加钱包账单明细
     * @param amount
     * @param cardId
     * @param type
     * @return
     */
    public Bill addToBill(BigDecimal amount, Integer cardId,Integer type){
        //钱包账单明细
        Bill bill=new Bill();
        bill.setAmount(amount);
        bill.setId(cardId);
        bill.setType(type);
        //添加明细
        //walletMapper.addBill(bill);
        return bill;
    }

}
