package func.task9_composition_func;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//You need to implement the conjunctAll method that accepts a list of IntPredicate
//objects and returns one composed IntPredicate. This predicate must be a conjunction
// of all the input predicates, i.e. it returns true only if the input predicates return true, otherwise it must be false.
//
//If the input list is empty, the resulted predicate must return true for any
// integer value (it is also known as always true predicate).
class CombiningPredicates {

    /**
     * The method represents the conjunction operator for a list of predicates.
     * For an empty list it returns the always true predicate.
     */
    public static IntPredicate conjunctAll(List<IntPredicate> predicates) {
        if (predicates.isEmpty()) return value -> true;
        IntPredicate result = predicates.get(0);
        for (IntPredicate predicate : predicates) {
            result = result.and(predicate);
        }
        return result;
    }

    // Don't change the code below
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] strings = scanner.nextLine().split("\\s+");

        List<Boolean> values;
        if (strings[0].trim().length() == 0) {
            values = List.of();
        } else {
            values = Arrays.stream(strings)
                           .map(Boolean::parseBoolean)
                           .collect(Collectors.toList());
        }

        List<IntPredicate> predicates = new ArrayList<>();
        values.forEach(v -> predicates.add(x -> v));

        System.out.println(conjunctAll(predicates).test(0));
    }
}
