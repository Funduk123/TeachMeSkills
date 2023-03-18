package com.tms.homework.service.impl;

import com.tms.homework.dto.Pair;
import com.tms.homework.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StartServiceImpl implements StartService {

    private final CashService cashService;
    private final RaceService raceService;
    private final ResultCheckerService resultChecker;
    private final PairService pairService;

    @Override
    public String start(List<Pair> pairs, int bet, int pairNumber) {

        cashService.setBet(bet);

        List<Pair> result = raceService.startRace(pairs);

        boolean isWinner = resultChecker.isWinner(result, pairs.get(pairNumber - 1));

        if (isWinner) {
            cashService.profit();
            Pair pair = pairs.get(0);
            return "Win pair: " + pair + ", CONGRATULATION!!! " + " | Your balance: " + cashService.getCash();
        } else {
            cashService.loss();
            Pair pair = pairs.get(0);
            return "Win pair: " + pair + ", You lose :(" + " | Your balance: " + cashService.getCash();
        }

    }

}