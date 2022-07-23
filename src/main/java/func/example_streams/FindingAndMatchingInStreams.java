package func.example_streams;

import java.util.List;
import java.util.stream.Stream;

public class FindingAndMatchingInStreams {
    private static List<Integer> numbers = List.of(5, 2, 7, 3, 12, 13, 7, 3);
    private static List<Integer> empty = List.of();

    public static void main (String[] args) {

        System.out.println("=============== findFirst or findAny ================");

        var var1  = Stream.of(1, 2, 3, 4, 5).findFirst().get(); // 1
        System.out.println("Stream.of(1, 2, 3, 4, 5).findFirst().get(): " + var1);
        var var2 = Stream.empty().findFirst().orElse(0); // 0 because of using the default value
        System.out.println("Stream.empty().findFirst().orElse(0): " + var2);

        var var3 = Stream.of(1, 2, 3, 4, 5).findAny().get(); // most likely it is 1, but no guarantee
        System.out.println("Stream.of(1, 2, 3, 4, 5).findAny().get(): " + var3);
        var var4 = Stream.empty().findAny().orElse(0); // 0 because of using the default value
        System.out.println("Stream.empty().findAny().orElse(0): " + var4);

        int foundNumber = numbers.stream()
                                 .filter(n -> n >= 10)
                                 .findFirst()
                                 .get();

        System.out.println("foundNumber: " + foundNumber); // 12


        System.out.println("=============== anyMatch ================");

        var var5 = numbers.stream().anyMatch(n -> n > 10);
        var var6 = numbers.stream().anyMatch(n -> n > 15);
        var var7 = empty.stream().anyMatch(n -> n > 10);
        var var8 = numbers.contains(7);
        var var9 = numbers.stream().anyMatch(n -> n == 7); //var8 and var9 is equivalent
        System.out.println("numbers.stream().anyMatch(n -> n > 10): " + var5);
        System.out.println("numbers.stream().anyMatch(n -> n > 15): " + var6);
        System.out.println("empty.stream().anyMatch(n -> n > 10): " + var7);
        System.out.println("numbers.contains(7): " + var8);
        System.out.println("numbers.stream().anyMatch(n -> n == 7): " + var9);


        System.out.println("=============== allMatch ================");

        var var10 = numbers.stream().allMatch(n -> n > 0);
        var var11 = numbers.stream().allMatch(n -> n < 10);
        var var12 = empty.stream().allMatch(n -> n < 10);

        System.out.println("numbers.stream().allMatch(n -> n > 0): " + var10);
        System.out.println("numbers.stream().allMatch(n -> n < 10): " + var11);
        System.out.println("empty.stream().allMatch(n -> n < 10): " + var12); //!!!empty collections, return always true

        System.out.println("=============== noneMatch ================");

        var var13 = numbers.stream().noneMatch(n -> n > 0);  // false, all elements > 0
        var var14 = numbers.stream().noneMatch(n -> n > 20); // true, because there are no elements > 20
        var var15 = empty.stream().noneMatch(n -> n > 10);   // true

        System.out.println("numbers.stream().noneMatch(n -> n > 0): " + var13);
        System.out.println("numbers.stream().noneMatch(n -> n > 20): " + var14);
        System.out.println("empty.stream().noneMatch(n -> n > 10): " + var15);

        System.out.println("===============  Short-circuit evaluation example ================");
        //In the following example, we have a stream containing five numbers. Once the first suitable
        // number is found, the stream stops filtering them. To demonstrate it, we also added the peek method that prints the element being filtered.
        // аналог сиквенса котлин
        int result = Stream.of(1, 2, 3, 4, 5)
                           .peek(System.out::println)
                           .filter(n -> n >= 3)
                           .findFirst()
                           .get();

        System.out.println("Result: " + result);

        boolean result2 = Stream.of(1, 2, 3, 4, 5)
                               .peek(System.out::println)
                               .allMatch(n -> n < 3);

        System.out.println("Result: " + result2); // false

    }
}
