package stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task2 {
    public static void main (String[] args) {
        findMinMax(
            Stream.of(9, 6, 8, 3, 19, 16, 18, 13),
            Integer::compareTo,
            (v1, v2) -> System.out.println("max = " + v2 + "\nmin = " + v1)
        );
        // 19 - 3 = 16
    }

    public static <T> void findMinMax (
        Stream<? extends T> stream, Comparator<? super T> order, BiConsumer<? super T, ? super T> minMaxConsumer
    )
    {
        List<? extends T> list1 = stream.collect(Collectors.toList());

        T value1 = list1.stream().min(order).orElse(null);
        T value2 = list1.stream().max(order).orElse(null);

        minMaxConsumer.accept(value1,value2);
    }
}
