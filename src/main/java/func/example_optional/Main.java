package func.example_optional;

import java.util.NoSuchElementException;
import java.util.Optional;

public class Main {
    public static void main (String[] args) {
        /* created empty Optional*/
        Optional<String> empty = Optional.empty();
        System.out.println("Optional is empty: " + empty.isEmpty());

        /* if pass null -> NPE*/
        String version = null;
        try {
            Optional<String> npeBatteryVersion = Optional.of(version);
        } catch (Exception e) {
            System.out.println("NPE");
        }

        /* pass null -> Optional */
        Optional<String> batteryVersion = Optional.ofNullable(version);
        System.out.println("Optional is empty: " + batteryVersion.isEmpty());

        /* method get(),return value or throw*/
        Optional<String> value1 = Optional.of("1000");
        String value1Result = value1.get();
        System.out.println("Optional get(): " + value1Result);
        value1 = Optional.empty();
        try {
            String value1EmptyResult = value1.get();
        } catch (NoSuchElementException e) {
            System.out.println("Optional get(): " + "throw NoSuchElementException");
        }

        /* check Optional value */
        Optional<String> version2 = Optional.of("T1000");
        boolean isPresent = version2.isPresent(); // true
        boolean isEmpty = version2.isEmpty(); // false
        System.out.println("Optional isPresent " + isPresent);
        System.out.println("Optional isEmpty: " + isEmpty);

        /* return else value */
        Optional<String> version3 = Optional.of("T-1000");
        System.out.println("Optional orElse: " + version3.orElse("T-600")); // "T-1000"
        Optional<String> version4 = Optional.empty();
        System.out.println("Optional orElse: " + version4.orElse("T-600")); // "T-600"
        Object orElseGet = Optional.ofNullable(null).orElseGet(Main::getStringValue);
        System.out.println("Optional orElseGet: " + orElseGet); // Hello world
        try {
            Optional<String> empty1 = Optional.empty();
            empty1.orElseThrow();
        } catch (NoSuchElementException exception) {
            System.out.println("Optional orElseThrow: " + "NoSuchElementException"); // Hello world
        }
        try {
            Optional<String> empty2 = Optional.empty();
            empty2.orElseThrow(RuntimeException::new);
        } catch (RuntimeException exception) {
            System.out.println("Optional orElseThrow: " + "RuntimeException"); // Hello world
        }


    }

    static String getStringValue() {
        return "Hello world";
    }
}
