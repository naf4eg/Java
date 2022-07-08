package func.example_streams;

import java.util.List;

public class Main {
    public static void main (String[] args) {
        List<String> courses = List.of(
            "Introduction to Java",
            "Kotlin for Java Developers",
            "Spring Framework",
            "Algorithms",
            "Scrum in practice"
        );

        courses
            .stream()
            .sorted()
            .limit(3)
            .forEach(System.out::println);

        System.out.println("--------------------------------------");

        courses.stream() // obtaining the stream
               .sorted() // an intermediate operation
               .skip(2)  // an intermediate operation
               .forEach(System.out::println); // the final operation
    }
}
