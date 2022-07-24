package func.task34_stream_reduce;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class InflationProblem {

    public static long calculateTotalPriceInFuture(int numberOfYears, List<Grocery> groceries) {
        return groceries
            .stream()
            .map(grocery -> grocery.getCost() * Math.pow(grocery.getCategory().getTimes(), numberOfYears))
            .map(Double::longValue)
            .reduce(0L, Long::sum);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfYears = Integer.parseInt(scanner.nextLine());

        List<Grocery> groceries = Stream.iterate(1, i -> scanner.hasNextLine(), i -> i + 1)
                                        .map(i -> scanner.nextLine())
                                        .map(inputLine -> {
                                            String[] parts = inputLine.split("\\s+");
                                            return new Grocery(Long.parseLong(parts[0]), Category.valueOf(parts[1]));
                                        })
                                        .collect(Collectors.toList());

        long totalPriceInFuture = calculateTotalPriceInFuture(numberOfYears, groceries);

        System.out.println(totalPriceInFuture);
    }
}
