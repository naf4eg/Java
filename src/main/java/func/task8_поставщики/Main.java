package func.task8_поставщики;

public class Main {
    @FunctionalInterface
    public interface TernaryIntPredicate {
        boolean test(Integer val1, Integer val2, Integer val3);
    }

    public static final TernaryIntPredicate allValuesAreDifferentPredicate = (a,b,c) -> a.compareTo(b) != 0
        && a.compareTo(c) != 0
        && b.compareTo(c) != 0;

    public static void main (String[] args) {
        System.out.println(allValuesAreDifferentPredicate.test(1,1,1));
        System.out.println(allValuesAreDifferentPredicate.test(1,2,1));
        System.out.println(allValuesAreDifferentPredicate.test(1,2,3));
    }
}
