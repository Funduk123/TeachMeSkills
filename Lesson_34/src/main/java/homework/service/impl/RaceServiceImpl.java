package homework.service.impl;

import homework.annotation.TimeCheck;
import homework.dto.Pair;
import homework.service.MonitoringService;
import homework.service.RaceService;
import homework.service.ResultCheckerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RaceServiceImpl implements RaceService {
    private final ResultCheckerService resultChecker;
    private final MonitoringService monitoring;

    @Override
    @TimeCheck
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

            monitoring.showWinner(counter, result);

            counter++;
        }

        return result;
    }
}
