package func.example_функ_интерфейсы;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.DoubleFunction;
import java.util.function.DoubleSupplier;
import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.function.UnaryOperator;

public class Main {
    public static void main (String[] args) {

        //*******************  Functions  ***************//

        // String to Integer function with the apply method
        Function<String, Integer> lengthFunc = String::length;
        int length = lengthFunc.apply("Hello");
        System.out.println(length);

        System.out.println("--------------------------");

        // (Integer, Integer) to Integer function with the apply method
        BiFunction<Integer, Integer, Integer> sum = (a, b) -> a + b;
        int sumResult = sum.apply(12, 18);
        System.out.println(sumResult);

        System.out.println("--------------------------");

        // String to int function with the applyAsInt method
        ToIntFunction<String> stringToInt = Integer::parseInt;
        Integer intResult = stringToInt.applyAsInt("1000");
        System.out.println(intResult);

        System.out.println("--------------------------");

        // Double to Long function
        DoubleFunction<Long> doubleConsumer = Math::round;
        Long doubleToLong = doubleConsumer.apply(10.64);
        System.out.println(doubleToLong);

        System.out.println("--------------------------");

        //*******************  Operators  ***************//

        // Integer to Integer operator
        UnaryOperator<Integer> intToInt = value -> value * 10;
        Integer intToIntResult = intToInt.apply(10);
        System.out.println(intToIntResult);

        System.out.println("--------------------------");

        // (String, String) to String operator
        BinaryOperator<String> stringStringToString = (value1, value2) -> value1 + " " + value2;
        String concatString = stringStringToString.apply("Hello", "World");
        System.out.println(concatString);

        System.out.println("--------------------------");

        // double to double operator
        DoubleUnaryOperator doubleToDouble = value -> Math.sqrt(value) * 2;
        double applyAsDouble = doubleToDouble.applyAsDouble(9.0);
        System.out.println(applyAsDouble);

        System.out.println("--------------------------");

        //*******************  Predicates  ***************//

        // String to boolean
        Predicate<String> startsWithDigit = s -> !s.isEmpty() && Character.isDigit(s.charAt(0));
        System.out.println(startsWithDigit.test("1st"));   // true
        System.out.println(startsWithDigit.test("Hello")); // false
        System.out.println(startsWithDigit.test(""));      // false

        System.out.println("--------------------------");

        // int to boolean predicate
        IntPredicate isEven = val -> val % 2 == 0;

        System.out.println(isEven.test(10)); // true
        System.out.println(isEven.test(11)); // false

        System.out.println("--------------------------");

        Predicate<LocalTime> isLunchTime = time -> time.isAfter(LocalTime.of(12, 0)) && time.isBefore(LocalTime.of(
            14,
            0
        ));

        LocalTime currentTime = LocalTime.now();
        if (isLunchTime.test(currentTime)) {
            System.out.println("It is time for lunch!");
        } else {
            System.out.println("No time for lunch!");
        }

        System.out.println("--------------------------");

        //*******************  Suppliers  ***************//

        Supplier<String> helloSupplier = () -> "Hello";
        System.out.println(helloSupplier.get()); // "Hello"

        Supplier<LocalDate> todaySupplier = LocalDate::now;
        System.out.println(todaySupplier.get()); // 2021-05-15 or something else

        BooleanSupplier booleanSupplier = () -> true;
        System.out.println(booleanSupplier.getAsBoolean()); // true

        DoubleSupplier randomGenerator = Math::random;
        System.out.println(randomGenerator.getAsDouble()); // 0.11253 or something else

        System.out.println("--------------------------");

        Queue<Integer> list = new ArrayDeque<>(List.of(1, 2, 3, 4));
        Supplier<Integer> supplier = list::poll;

        System.out.println(supplier.get()); // 1
        System.out.println(supplier.get()); // 2
        System.out.println(supplier.get()); // 3

        System.out.println("--------------------------");

        //*******************  Suppliers  ***************//
        // it prints a given string
        Consumer<String> printer = System.out::println; // s -> System.out.println(s)
        printer.accept("!!!"); // !!!
        printer.accept("Hello"); // Hello

        List<Integer> numbers = new ArrayList<>();
        Consumer<Integer> consumer = numbers::add; // it just adds new numbers to the list
        consumer.accept(1);
        consumer.accept(2);
        consumer.accept(3);
        System.out.println(numbers);
    }
}
