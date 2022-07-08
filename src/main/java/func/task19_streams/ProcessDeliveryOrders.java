package func.task19_streams;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class ProcessDeliveryOrders {

    public static DeliveryOrder findFirstOrder(List<DeliveryOrder> orders) {
        return orders
            .stream()
            .distinct()
            .sorted(DeliveryOrder.getComparatorByDeliveryDate())
            .findFirst()
            .orElse(new DeliveryOrder());
    }

    public static void printAddressesToDeliver(List<DeliveryOrder> orders) {
        orders
            .stream()
            .distinct()
            .sorted(DeliveryOrder.getComparatorByDeliveryDate())
            .map(DeliveryOrder::getAddress)
            .forEach(System.out::println);
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        List<DeliveryOrder> orders = Stream.iterate(1, i -> scanner.hasNextLine(), i -> i + 1)
                                           .map(i -> scanner.nextLine().split("\\|"))
                                           .map(parts -> new DeliveryOrder(
                                               Long.parseLong(parts[0]), parts[2], LocalDate.parse(parts[1])))
                                           .collect(Collectors.toList());

        System.out.println(findFirstOrder(orders));

        printAddressesToDeliver(orders);
    }
}
