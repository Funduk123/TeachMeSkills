package homework.service;

import homework.dto.Pair;

import java.util.List;

public interface ResultCheckerService {

    List<Pair> getResult(List<Pair> pairs);

    boolean isWinner(List<Pair> pairs, Pair chosen);

}
