package com.tms.homework.service;

import com.tms.homework.dto.Pair;

import java.util.List;

public interface PairService {

    void addPair(String horseName, String riderName);

    List<Pair> getAll();

}
