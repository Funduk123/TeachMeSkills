package homework.dto;

public class Worker extends Employee {

    public Worker() {
        position = Position.WORKER;
    }

    public Worker(String firstName, String surname, int experience) {
        super(firstName, surname, experience);
        position = Position.WORKER;
    }

    @Override
    public String toString() {
        return "Рабочий -> " + super.toString();
    }
}
