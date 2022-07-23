package func.task23_streams;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Here you need to use one of the methods learned in this lesson to implement the getStream method that produces a stream containing sorted unique numbers that are strictly less than 100.
 * As the problem is not difficult and it has several solutions, you can try to solve it several times using different methods to consolidate your knowledge.
 *
 * Sample Input:
 * 40 100 50 30 60 110 40 70 120
 *
 * Sample Output:
 * 30 40 50 60 70
 */
public class ProcessingNumbers {

    public static Stream<Integer> getStream(Collection<Integer> numbers) {
        return numbers.stream()
            .sorted()
            .distinct()
            .takeWhile(n -> n < 100);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                                      .map(Integer::parseInt)
                                      .collect(Collectors.toList());

        String result = getStream(numbers)
            .map(String::valueOf)
            .collect(Collectors.joining(" "));

        System.out.println(result);
    }
}
