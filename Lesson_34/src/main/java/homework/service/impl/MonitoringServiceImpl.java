package homework.service.impl;

import homework.annotation.TimeCheck;
import homework.dto.Pair;
import homework.service.MonitoringService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonitoringServiceImpl implements MonitoringService {
    @Override
    public void showWinner(int circle, List<Pair> pairs) {

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Круг № " + circle);

        for (int i = 0; i < pairs.size(); i++) {
            System.out.println((i + 1) + " место: " + pairs.get(i));
        }

    }

    @Override
    public void showResult(int cash, boolean isWinner) {

        if (isWinner) {
            System.out.println("Вы выйграли. Ваш баланс: " + cash + "$");
        } else {
            System.out.println("Вы проиграли. Ваш баланс: " + cash + "$");
        }

    }
}