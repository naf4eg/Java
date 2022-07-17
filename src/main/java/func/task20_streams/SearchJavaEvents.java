package func.task20_streams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Here you need to implement the printSortedJavaEvents method that takes a list of event titles and must print only the names of Java-related events in the alphabetical order.
 * An event is considered a Java-related if it contains the substring "Java" in the title. It is important that this substring can be written in any case: "java", "Java", "JAVA", etc, and they all must count.
 */
public class SearchJavaEvents {
    public static void printSortedJavaEvents(List<String> events) {
        Predicate<String> strContainsJava = value -> value.trim().toLowerCase().contains("java");

        events.stream()
            .filter(strContainsJava)
            .sorted()
            .forEach(System.out::println);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> events = Stream
            .iterate(1, i -> scanner.hasNextLine(), i -> i + 1)
            .map(i -> scanner.nextLine())
            .collect(Collectors.toList());

        printSortedJavaEvents(events);
    }
}
