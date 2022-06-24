package stream;

import java.util.Comparator;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class task {
    public static void main(String[] args) {
        pseudoRandomStream(13);
        //13, 16, 25, 62, 384, 745, 502, 200, 0, ... (дальше бесконечное количество нулей)

        Stream<Integer> value = Stream.of(1,2,3);
        System.out.println(value.min(
            (o1, o2) -> {
                if (o1.intValue() > o2.intValue()) {
                    return 1;
                }
                if (o1.intValue() < o2.intValue()) {
                    return -1;
                }
                return 0;
            }
        ).get());
    }

    public static IntStream pseudoRandomStream(int seed) {
        IntStream stream = IntStream
            .iterate(
                seed,
                x -> {
                    Integer v = x * x;
                    return (v-(v/10000)*10000)/10;
                }
            )
            .limit(10);

        return stream;
    }
}


