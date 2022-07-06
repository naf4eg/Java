package func.task13_sort_в_func;

import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main (String[] args) {
        Set<LongRange> numbers = new TreeSet<>(LongRange.getComparator());

        numbers.add(new LongRange(0, 5));
        numbers.add(new LongRange(2, 4));
        numbers.add(new LongRange(1, 4));
        numbers.add(new LongRange(1, 7));
        numbers.add(new LongRange(3, 5));

        numbers.forEach(System.out::println);

        numbers.clear();
        System.out.println("----------------cleared---------");

        numbers.add(new LongRange(0, 10));
        numbers.add(new LongRange(-10, 0));
        numbers.add(new LongRange(0, 5));
        numbers.add(new LongRange(-4, 1));

        numbers.forEach(System.out::println);
    }
}
