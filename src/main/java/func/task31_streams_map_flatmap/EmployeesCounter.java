package func.task31_streams_map_flatmap;

import java.util.List;

/**
 * Your task is to implement a method that calculates the total number of employees
 * with salary >= threshold for all departments whose code starts with the string
 * "111-" (without ""). Try to apply your knowledge of the Stream API and especially
 * the flatMap method to provide the implementation.
 *
 * An example: there is a list containing two departments and the threshold is 20 000.
 */
public class EmployeesCounter {

    public static void main (String[] args) {
        List<Department> departments = List.of(
            new Department("dep-1", "111-1", List.of(
                new Employee("William", 15000L),
                new Employee("Sophia", 22000L),
                new Employee("John", 20000L)
            )),
            new Department("dep-2", "222-1", List.of(
                new Employee("Victor", 25000L)
            ))
        );

        System.out.println(calcNumberOfEmployees(departments, 20000L));
    }

    public static long calcNumberOfEmployees(List<Department> departments, long threshold) {
        return departments
            .stream()
            .filter(department -> department.getCode().contains("111-"))
            .flatMap(department -> department.getEmployees().stream())
            .filter(employee -> employee.getSalary() >= threshold)
            .count();
    }
}
