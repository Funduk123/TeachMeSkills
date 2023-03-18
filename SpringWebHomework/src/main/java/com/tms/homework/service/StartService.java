package com.tms.homework.service;

import com.tms.homework.dto.Pair;

import java.util.List;

public interface StartService {

    String start(List<Pair> pairs, int bet, int pairNumber);

}
