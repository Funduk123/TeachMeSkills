package com.tms.homework.service;

import com.tms.homework.dto.Pair;

import java.util.List;

public interface ResultCheckerService {

    List<Pair> getResult(List<Pair> pairs);

    boolean isWinner(List<Pair> pairs, Pair chosen);

}
