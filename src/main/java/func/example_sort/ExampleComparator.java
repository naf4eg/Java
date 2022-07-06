package func.example_sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ExampleComparator {
    public static void main (String[] args) {
        List<Laptop> laptops = new ArrayList<>();
        laptops.add(new Laptop("HP", 4, 15.6));
        laptops.add(new Laptop("Apple", 6, 15.6));
        laptops.add(new Laptop("Asus", 4, 14.1));
        laptops.add(new Laptop("Dell", 8, 17.0));
        laptops.add(new Laptop("Old but work", 1, 15.1));

        Comparator<Laptop> sortByCore = (l1,l2) -> Integer.compare(l1.getNumberOfCores(), l2.getNumberOfCores());
        laptops.sort(sortByCore);
        laptops.forEach(System.out::println);

        System.out.println("------------------------------------------");

        Comparator<Laptop> sortByCore2 = Comparator.comparingInt(Laptop::getNumberOfCores);
        laptops.sort(sortByCore2);
        laptops.forEach(System.out::println);
    }
}
