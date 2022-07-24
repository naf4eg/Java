package func.example_streams;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ReduceInStreams {

    static class Payment {
        /**
         * When the payment was made
         */
        private final LocalDateTime date;
        /**
         * The amount of money in dollars
         */
        private final long amountInDollars;

        Payment(LocalDateTime date, long amountInDollars) {
            this.date = date;
            this.amountInDollars = amountInDollars;
        }

        public LocalDateTime getDate () {
            return date;
        }

        public long getAmountInDollars () {
            return amountInDollars;
        }
    }
    public static void main (String[] args) {

        System.out.println("=============== Reduce ================");
        List<Integer> spendings = List.of(14, 22, 10, 18, 16, 15, 20);
        int total = spendings.stream()
                             .reduce((partialSum, next) -> partialSum + next)
                             .orElse(0);
        System.out.println("total: " + total);

        System.out.println("=============== Reduce with identity param ================");
        int total2 = spendings.stream().reduce(0, Integer::sum);
        System.out.println("total2: " + total2);

        System.out.println("=============== Other methods for reduction ================");
        List<Integer> spendings2 = List.of(14, 22, 10, 18, 16, 15, 20);
        Integer maxRed = spendings2.stream().reduce(0, (max, next) -> max > next ? max : next);
        System.out.println("max reduce: " + maxRed);
        Integer maxValue = spendings2.stream().max(Integer::compareTo).orElse(0);
        System.out.println("max value: " + maxValue);

        System.out.println("=============== Collectors with reducing ================");
        List<Payment> payments = List.of(
            new Payment(LocalDateTime.now(), 50),
            new Payment(LocalDateTime.now(), 21),
            new Payment(LocalDateTime.now(), 34),
            new Payment(LocalDateTime.now(), 15)
        );
        Optional<Long> totalAmount = payments.stream()
                                         .map(Payment::getAmountInDollars)
                                         .collect(Collectors.reducing((max, next) -> max + next));
        System.out.println("Total amount: " + totalAmount.get());

        System.out.println("=============== Collectors with reducing with identity ================");
        long totalAmount2 = payments.stream()
                                             .map(Payment::getAmountInDollars)
                                             .collect(Collectors.reducing(0L, (max, next) -> max + next));
        System.out.println("Total amount: " + totalAmount2);

        System.out.println("=============== Reducing collector with identity and mapper ================");
        long amountInCents = payments.stream()
                                     .map(Payment::getAmountInDollars)
                                     .collect(Collectors.reducing(
                                         0L,
                                         amount -> amount * 100,
                                         Long::sum
                                     ));
        System.out.println("amountInCents: " +  amountInCents);

    }
}
