package func.task18_streams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/*
For some historical reason, your company stores first names of employees on two lists. You were asked to end this and merge both the lists into one. In addition, there is an additional requirement that the company wants you to sort this new list in the alphabetical order.
To solve this, you need to implement the mergeEmployees method that takes two streams containing the names of employees. The method must return a new stream that suits all the requirements above.

Sample Input:
Jess Clarisa Noe Jeri
Helena Kristin Juan

Sample Output:
Clarisa
Helena
Jeri
Jess
Juan
Kristin
Noe
 */
class MergingEmployees {

    public static Stream<String> mergeEmployees(Stream<String> empls1, Stream<String> empls2) {
        return Stream.concat(empls1, empls2).sorted();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> employees1 = convertLineToEmployees(scanner.nextLine());
        List<String> employees2 = convertLineToEmployees(scanner.nextLine());

        mergeEmployees(employees1.stream(), employees2.stream()).forEach(System.out::println);
    }

    private static List<String> convertLineToEmployees(String line) {
        return Arrays.stream(line.split("\\s+")).collect(Collectors.toList());
    }
}
