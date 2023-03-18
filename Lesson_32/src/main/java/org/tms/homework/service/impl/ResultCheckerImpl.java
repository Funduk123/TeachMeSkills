package org.tms.homework.service.impl;

import org.tms.homework.dto.Pair;
import org.tms.homework.service.PairComparator;
import org.tms.homework.service.ResultChecker;

import java.util.List;

public class ResultCheckerImpl implements ResultChecker {
    @Override
    public List<Pair> getResult(List<Pair> pairs) {
        pairs.sort(new PairComparator());
        return pairs;
    }

    @Override
    public boolean isWinner(List<Pair> pairs, Pair chosen) {
        return chosen.equals(pairs.get(0));
    }
}
