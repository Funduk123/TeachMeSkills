package com.tms.homework.service.impl;

import com.tms.homework.dto.Horse;
import com.tms.homework.dto.Pair;
import com.tms.homework.dto.Rider;
import com.tms.homework.service.PairService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PairServiceImpl implements PairService {

    public List<Pair> pairs = new ArrayList<>();

    @Override
    public void addPair(String horseName, String riderName) {
        Pair pair = new Pair(pairs.size() + 1, new Horse(horseName), new Rider(riderName));
        pairs.add(pair);
    }

    @Override
    public List<Pair> getAll() {
        return this.pairs;
    }

}
