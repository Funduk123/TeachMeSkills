package patterns.behavioral.state.service;

public class DifMathServiceImpl implements MathService {
    @Override
    public int calc(int v1, int v2) {
        System.out.print(v1 + " - " + v2 + " = ");
        return v1 - v2;
    }
}
