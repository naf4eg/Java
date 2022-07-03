package func.task9_composition_func;

import java.util.function.Predicate;

//The exclusive OR Predicate
//There is a well known logical operation called exclusive or (or simply, xor) that is often used in low-level programming and crypto algorithms. The rule for this operation is very simple: it returns true only if both boolean operands are different, otherwise, it returns false.
//
//Java provides this operation for boolean expressions and it is denoted as ^. However the predicates do not provide this operation for composition.
//
//In this task you need to create the xor operation using all of and, or and not. There are several ways how to get it but the simplest one is just to follow the formula: A or B, but not(A and B).
//
//If you need to test your code locally, just create a couple of predicates and try to combine them to get the xor predicate.
public class Main {

    public static void main (String[] args) {
        Predicate<Integer> one = x -> x == 10;
        Predicate<Integer> two = x -> x == 10;

        System.out.println(one.and(two).test(10));

        var result = xor(one, two);
        System.out.println(result.test(10));
    }

    public static <T> Predicate<T> xor (Predicate<T> predicate1, Predicate<T> predicate2) {
        return predicate1.or(predicate2).and(predicate1.and(predicate2).negate());
    }
}
