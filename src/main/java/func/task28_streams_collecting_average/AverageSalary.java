package func.task28_streams_collecting_average;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Imagine you have a list of employees. Each employee has a name and a salary (in abstract units).
 * You need to implement the averageSalary method to return the average salary of all employees from the
 * list as a double value. If the given list is empty, the result must be zero.
 *
 * Sample Input:
 * John 5000
 * Alise 6000
 * Sonya 3000
 * Chester 4000
 *
 * Sample Output:
 * 4500.0
 */
class AverageSalary {

    public static double averageSalary (List<Employee> employees) {
        //        return employees
        //            .stream()
        //            .map(Employee::getSalary)
        //            .collect(
        //                Collectors.averagingDouble(Long::doubleValue)
        //            );

        return employees.stream().collect(Collectors.averagingDouble(Employee::getSalary));
    }

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Employee> employees = Stream.iterate(1, i -> scanner.hasNextLine(), i -> i + 1)
                                         .map(i -> scanner.nextLine()
                                                          .split("\\s+"))
                                         .map(parts -> new Employee(parts[0], Long.parseLong(parts[1])))
                                         .collect(Collectors.toList());

        System.out.println(averageSalary(employees));
    }
}
