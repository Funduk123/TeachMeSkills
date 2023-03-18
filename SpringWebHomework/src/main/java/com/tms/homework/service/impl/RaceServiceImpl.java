package com.tms.homework.service.impl;

import com.tms.homework.dto.Pair;
import com.tms.homework.service.RaceService;
import com.tms.homework.service.ResultCheckerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RaceServiceImpl implements RaceService {
    private final ResultCheckerService resultChecker;

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

            result = resultChecker.getResult(pairs);

            counter++;
        }

        return result;
    }
}
