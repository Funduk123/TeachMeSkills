package com.tms.homework.service;

import com.tms.homework.dto.Pair;

import java.util.Comparator;

public class PairComparator implements Comparator<Pair> {

    
    @Override
    public int compare(Pair o1, Pair o2) {
        return o2.getOverallSpeed() - o1.getOverallSpeed();
    }

}
