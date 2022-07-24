package func.task29_streams_map;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AbsoluteNumbers {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        String result = Arrays.stream(scanner.nextLine().split("\\s+"))
                              .map(Integer::parseInt)
                              .map(Math::abs)
                              .map(Object::toString)
                              .collect(
                                Collectors.joining(" ")
                              );

        System.out.println(result);
    }
}
