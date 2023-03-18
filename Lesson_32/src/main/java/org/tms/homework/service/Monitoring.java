package org.tms.homework.service;

import org.tms.homework.dto.Pair;

import java.util.List;

public interface Monitoring {

    void showWinner(int circle, List<Pair> pairs);

    void showResult(int cash, boolean isWinner);

}
