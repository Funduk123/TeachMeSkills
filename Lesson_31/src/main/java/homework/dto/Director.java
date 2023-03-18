package homework.dto;

import java.util.List;

public class Director extends Employee {

    private final List<Employee> workersList;

    public Director(String firstName, String surname, int experience, List<Employee> workersList) {
        super(firstName, surname, experience);
        this.workersList = workersList;
        position = Position.DIRECTOR;
    }

    public List<Employee> getWorkersList() {
        return workersList;
    }

    public void addWorker(Employee employee) {
        workersList.add(employee);
    }

    public String showWorkersList() {
        if (workersList.size() == 0) {
            return "Подчиненных нет!";
        } else {
            String list = "";
            int i = 1;
            for (Employee emp : workersList) {
                list = list + "\n" + i + ") " + emp + '\n' + emp.salary();
                i++;
            }
            return list;
        }
    }

    @Override
    public double salary() {
        return 1000 * position.coefficient * super.getExperience() + workersList.size() * 100;
    }

    @Override
    public String toString() {
        return "Директор -> " + super.toString() + '\n' +
                "Список подчиненных: " + showWorkersList();
    }
}