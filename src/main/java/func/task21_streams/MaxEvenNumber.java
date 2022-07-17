package func.task21_streams;

import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * You need to implement the findMaxEvenNumber method to find the maximum number that is divisible by 2 (even).
 * The method should return the found number or 0 if the stream doesn't contain any even numbers.
 */
public class MaxEvenNumber {
    public static int findMaxEvenNumber (Collection<Integer> numbers) {
        return numbers
            .stream()
            .filter(num -> num % 2 == 0)
            .max(Integer::compareTo)
            .orElse(0);
    }

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                                     .map(Integer::parseInt)
                                     .collect(Collectors.toSet());

        System.out.println(findMaxEvenNumber(numbers));
    }
}
