package com.tms.homework.service.impl;

import com.tms.homework.service.CashService;
import org.springframework.stereotype.Service;

@Service
public class CashServiceImpl implements CashService {
    private Integer startCash = 1000;
    private Integer bet;

    @Override
    public void setBet(Integer bet) {
        if (bet <= startCash) {
            this.bet = bet;
        } else {
            throw new RuntimeException("Недостаточно средств!");
        }
    }

    @Override
    public Integer getCash() {
        return startCash;
    }

    @Override
    public void profit() {
        this.startCash = startCash + bet * 2;
    }

    @Override
    public void loss() {
        this.startCash = startCash - bet;
    }
}
