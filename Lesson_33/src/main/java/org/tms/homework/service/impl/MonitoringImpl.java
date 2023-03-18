package org.tms.homework.service.impl;

import org.springframework.stereotype.Service;
import org.tms.homework.dto.Pair;
import org.tms.homework.service.Monitoring;

import java.util.List;

@Service
public class MonitoringImpl implements Monitoring {
    @Override
    public void showWinner(int circle, List<Pair> pairs) {

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
