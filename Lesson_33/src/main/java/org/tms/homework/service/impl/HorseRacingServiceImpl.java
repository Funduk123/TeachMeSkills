package org.tms.homework.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.tms.homework.dto.Pair;
import org.tms.homework.service.*;

import java.util.List;
import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class HorseRacingServiceImpl implements HorseRacingService {

    private final CashService cashService;
    private final RaceService raceService;
    private final ResultChecker resultChecker;
    private final Monitoring monitoring;

    @Override
    public void start(List<Pair> pairs) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите стартовый баланс: ");
        cashService.setStartCash(scanner.nextInt());

        System.out.println("Список участников: ");
        pairs.forEach(Pair::show);

        System.out.println("Введите номер пары (от 1 до 3): ");
        int pairNumber = scanner.nextInt();

        Pair chosenPair = pairs.get(pairNumber - 1);
        System.out.println("Вы выбрали пару: " + chosenPair);

        System.out.println("Введите сумму ставки: ");
        cashService.setBet(scanner.nextInt());

        List<Pair> result = raceService.startRace(pairs);

        boolean isWinner = resultChecker.isWinner(result, chosenPair);

        if (isWinner) {
            cashService.profit();
        } else {
            cashService.loss();
        }

        monitoring.showResult(cashService.getCash(), isWinner);

        scanner.close();
    }
}
