package func.task32_streams_reduce;

import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Here you need to implement the sumOfAbsoluteNumbers method to calculate the sum of long numbers regardless their sign.
 * Pay attention that here you work with the long type.
 *
 * Sample Input 1:
 * 7 3 -5 2
 *
 * Sample Output 1:
 * 17
 */
class AbsoluteSum {
    public static long sumOfAbsoluteNumbers(Collection<Long> numbers) {
        return numbers
            .stream()
            .map(Math::abs)
            .reduce(0L, Long::sum);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Collection<Long> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                                         .map(Long::parseLong)
                                         .collect(Collectors.toList());
        System.out.println(sumOfAbsoluteNumbers(numbers));
    }
}
