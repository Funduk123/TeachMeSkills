package homework.service.impl;

import homework.annotation.TimeCheck;
import homework.dto.Pair;
import homework.service.*;
import lecture.aop.MyBenchmark;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class StartServiceImpl implements StartService {

    private final CashService cashService;
    private final RaceService raceService;
    private final ResultCheckerService resultChecker;
    private final MonitoringService monitoring;

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