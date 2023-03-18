package homework.service.impl;

import homework.dto.Pair;
import homework.service.PairComparator;
import homework.service.ResultCheckerService;
import org.springframework.stereotype.Service;

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