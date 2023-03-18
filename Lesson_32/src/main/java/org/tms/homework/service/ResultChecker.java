package org.tms.homework.service;

import org.tms.homework.dto.Pair;

import java.util.List;

public interface ResultChecker {

    List<Pair> getResult(List<Pair> pairs);

    boolean isWinner(List<Pair> pairs, Pair chosen);

}
