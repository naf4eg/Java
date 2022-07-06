package func.example_sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComposingComparators {
    public static void main (String[] args) {
        List<Laptop> laptops = new ArrayList<>();
        laptops.add(new Laptop("HP", 4, 15.6));
        laptops.add(new Laptop("Apple", 6, 15.6));
        laptops.add(new Laptop("Asus", 4, 14.1));
        laptops.add(new Laptop("Dell", 8, 17.0));
        laptops.add(new Laptop("Old but work", 1, 15.1));

        /* Here is a comparator that sorts the laptops by the number of cores descending
        and if this number is the same for several objects, also sorts them by the display size ascending. */
        laptops.sort(Comparator
            .comparing(Laptop::getNumberOfCores, Comparator.reverseOrder())
            .thenComparingDouble(Laptop::getDisplaySize));

        laptops.forEach(System.out::println);
    }
}
