package func.example_streams;

import java.util.List;
import java.util.stream.Collectors;

public class TransformingElements {
    public static void main (String[] args) {

        System.out.println("=============== Map ================");

        List<String> numbersAsStrings = List.of("10", "11", "12", "13", "14");
        List<Integer> numbersMultipliedBy2 = numbersAsStrings.stream()
                                                             .map(Integer::parseInt)
                                                             .map(n -> n * 2)
                                                             .collect(Collectors.toList()); // [20, 22, 24, 26, 28]
        System.out.println(numbersAsStrings);
        System.out.println(numbersMultipliedBy2);



    }
}
