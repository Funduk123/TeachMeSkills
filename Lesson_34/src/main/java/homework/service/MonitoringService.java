package homework.service;

import homework.dto.Pair;

import java.util.List;

public interface MonitoringService {

    void showWinner(int circle, List<Pair> pairs);

    void showResult(int cash, boolean isWinner);

}
