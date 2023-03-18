package homework.service;

import homework.dto.Director;
import homework.dto.Employee;

import java.util.Optional;

public class DeepSearchService {

    public String deepSearch(String firstName, String surname, Director director) {

        Optional<Employee> employeeOptional = director.getWorkersList().stream()
                .filter
                        (
                                employee -> employee.getFirstName().equals(firstName)
                                        && employee.getSurname().equals(surname)
                        )
                .findFirst();

        if (employeeOptional.isPresent()) {
            return "есть в подчинении";
        } else {
            for (Employee employ : director.getWorkersList()) {
                if (employ instanceof Director) {
                    return deepSearch(firstName, surname, (Director) employ);
                }
            }
            return "нет в подчинении";
        }
    }
}