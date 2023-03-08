package com.example.demo.controller;

import com.example.demo.dto.Result;
import com.example.demo.entity.Wallet;
import com.example.demo.mapper.WalletMapper;
import com.example.demo.service.WalletService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

@RestController
@RequestMapping("/wallet")
public class WalletController {
    @Resource
    WalletService walletService;

    /**
     * 查询钱余额
     * @param cardId
     * @return
     */
    @PostMapping("query")
    public Result queryBal(@RequestParam Integer cardId){
        return walletService.query(cardId);
    }

    /**
     * 钱包消费金额
     * @param amount
     * @return
     */
    @PostMapping("consume")
    public Result consume(@RequestParam BigDecimal amount,@RequestParam Integer cardId){

        return walletService.consume(amount,cardId);
    }

    /**
     * 用户退款
     * @param amount
     * @return
     */
    @PostMapping("back")
    public Result drawback(@RequestParam BigDecimal amount,@RequestParam Integer cardId){
        return  walletService.back(amount,cardId);
    }

    /**
     * 用户钱包金额变动明细
     * @param cardId
     * @return
     */
    @PostMapping("bill")
    public Result billList(@RequestParam Integer cardId){
        return walletService.billList(cardId);
    }
}


