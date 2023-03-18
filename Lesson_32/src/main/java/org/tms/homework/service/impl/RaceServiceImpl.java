package org.tms.homework.service.impl;

import org.tms.homework.dto.Pair;
import org.tms.homework.service.Monitoring;
import org.tms.homework.service.RaceService;
import org.tms.homework.service.ResultChecker;

import java.util.ArrayList;
import java.util.List;

public class RaceServiceImpl implements RaceService {

    private final ResultChecker resultChecker;
    private final Monitoring monitoring;

    public RaceServiceImpl(ResultChecker resultChecker, Monitoring monitoring) {
        this.resultChecker = resultChecker;
        this.monitoring = monitoring;
    }

    @Override
    public List<Pair> startRace(List<Pair> pairs) {

        int counter = 1;

        List<Pair> result = new ArrayList<>();

        while (counter < 6) {
            for (Pair pair : pairs) {
                int speed = pair.getOverallSpeed();
                speed = speed + (int) (Math.random() * 20);
                pair.setOverallSpeed(speed);
            }

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            result = resultChecker.getResult(pairs);

            monitoring.showWinner(counter, result);

            counter++;
        }

        return result;
    }
}
