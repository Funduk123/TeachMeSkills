package homework;

import homework.dto.Director;
import homework.dto.Employee;
import homework.dto.Worker;
import homework.service.DeepSearchService;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("------------------- 1 ---------------------");

        Employee worker1 = new Worker("Данила", "Ребковец", 2);
        Employee worker2 = new Worker("Глеб", "Миронов", 3);

        List<Employee> employeeList = new ArrayList<>();

        Director director1 = new Director("Сергей", "Макаров", 10, employeeList);

        System.out.println(worker1 + "\nитоговая з/п: " + worker1.salary());
        System.out.println(worker2 + "\nитоговая з/п: " + worker2.salary());

        System.out.println(director1 + "\nитоговая з/п: " + director1.salary());
        System.out.println();

        System.out.println("------------------- 2 ---------------------");

        employeeList.add(worker1);
        employeeList.add(worker2);

        System.out.println(director1 + "\nитоговая з/п: " + director1.salary());
        System.out.println();

        System.out.println("------------------- 3 - 4 ---------------------");

        Employee worker3 = new Worker("Святослав", "Кирпик", 5);

        List<Employee> employeeList1 = new ArrayList<>();

        employeeList1.add(worker3);

        Director director2 = new Director("Ольга", "Лисиченко", 6, employeeList1);

        director1.addWorker(director2);

        System.out.println(director1 + "\nитоговая з/п: " + director1.salary());
        System.out.println();

        System.out.println("------------------- 5 ---------------------");

        DeepSearchService service = new DeepSearchService();

        String searchResult = service.deepSearch("Святослав", "Кирпик", director2);

        System.out.println(searchResult);
    }

}
