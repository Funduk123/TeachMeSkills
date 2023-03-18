package com.tms.homework.service.impl;

import com.tms.homework.dto.Pair;
import com.tms.homework.service.PairComparator;
import com.tms.homework.service.ResultCheckerService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class ResultCheckerServiceImpl implements ResultCheckerService {

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