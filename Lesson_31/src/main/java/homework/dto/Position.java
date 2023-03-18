package homework.dto;

public enum Position {

    DIRECTOR(1.4),
    WORKER(1);

    public final double coefficient;

    Position(double coefficient) {
        this.coefficient = coefficient;
    }

}
