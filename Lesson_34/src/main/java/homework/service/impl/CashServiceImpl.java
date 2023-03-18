package homework.service.impl;

import homework.service.CashService;
import org.springframework.stereotype.Service;

@Service
public class CashServiceImpl implements CashService {
    private int startCash;
    private int bet;

    @Override
    public void setBet(int bet) {
        if (bet <= startCash) {
            this.bet = bet;
        } else {
            throw new RuntimeException("Недостаточно средств!");
        }
    }

    @Override
    public void setStartCash(int startCash) {
        this.startCash = startCash;
    }

    @Override
    public int getCash() {
        return startCash;
    }

    @Override
    public void profit() {
        startCash = startCash + bet * 2;
    }

    @Override
    public void loss() {
        startCash = startCash - bet;
    }
}
