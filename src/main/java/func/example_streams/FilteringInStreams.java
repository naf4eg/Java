package func.example_streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class FilteringInStreams {
    public static void main (String[] args) {
        List<Integer> numbers = Arrays.asList(26, 78, 30, 17, 11, 34, 42, 80, 16, 55);

        /* Let's look at an example. Assume that there is a list containing integers and we would like to print out only those numbers that are greater than 40. */
        numbers.stream()
            .filter(n -> n > 40)
            .forEach(System.out::println);

        System.out.println("===============================");

        /* A Predicate can consist of multiple parts concatenated by boolean operators. Here is an example with a more complex condition that allows going ahead with the numbers that are greater than 40 and can be divided by 5. */
        numbers.stream()
            .filter(n -> n > 40 && n % 5 == 0)
            .forEach(System.out::println);

        System.out.println("===============================");

        /* If you would like to make the stream more readable and closer to the text, you may replace the lambda expression with an explicitly created object of the Predicate class. Moreover, these objects can use the function composition using the and, or and negate methods provided by this class */
        Predicate<Integer> isGreaterThan40 = n -> n > 40;
        Predicate<Integer> isDivisibleBy5 = n -> n % 5 == 0;
        numbers.stream()
            .filter(isGreaterThan40.and(isDivisibleBy5))
            .forEach(System.out::println);

        System.out.println("===============================");

        List<String> programmers = List.of(
            "James Gosling",
            "Guido van Rossum",
            "John Carmack",
            "Linus Torvalds",
            "Ken Thompson",
            "Joshua Bloch"
        );

        long result = programmers.stream()
                                 .filter(name -> name.startsWith("J") && name.length() <= 12)
                                 .count();
        System.out.println(result);

    }
}
