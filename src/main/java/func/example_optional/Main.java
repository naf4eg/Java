package func.example_optional;

import java.util.NoSuchElementException;
import java.util.Optional;

/*
While Optional provides a lot of improvements, it's easy to misuse it. There are a few pieces of advice that can help you to avoid such mistakes:

1) Avoid returning null. In most cases, the clients of your API expect that the response is safe. Returning null leads to NullPointerException, and it's a bad way to build your API. One option is to return the Optional.empty instead.
2) Don't use Optional as a method parameter. If the method has an Optional parameter, you have to do the unnecessary wrapping and pack an argument into Optional. It leads to low code readability. If the method parameter is optional to have, use overloading instead.
3) In most cases, it's more convenient to use the Optional.map and the Optional.flatMap instead of the Optional.ifPresent to avoid unnecessary if checks.
4) Since Optional is not serializable, don't use it for class fields. The primary design goal of Optional is to be used as the return value of functions when a return value might be absent.
5) Last but not least: keep it simple, don't overuse Optional.
 */
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

        /* Conditional actions */
        Optional
            .of("t-1000")
            .ifPresent(ver -> System.out.println(ver.toUpperCase())); //T-1000

        Optional
            .of("t-1000")
            .ifPresentOrElse(
                value -> System.out.println(value.toUpperCase()), //call this method
                () -> System.out.println("Optional is empty")
            );

        Optional
            .empty()
            .ifPresentOrElse(
                System.out::println,
                () -> System.out.println("Optional is empty") //call this method
            );

        Optional
            .of("T-1000")
            .or(() -> Optional.of("T-800"))
            .ifPresent(System.out::println); //T-1000

        Optional
            .empty()
            .or(() -> Optional.of("T-800"))
            .ifPresent(System.out::println); //T-800

        /* Filtering Optionals */
        Optional
            .of("V-1000")
            .filter(str -> str.contains("1000"))
            .ifPresent(System.out::println); //V-1000

        Optional
            .of("R-1000")
            .filter(str -> str.contains("43"))
            .ifPresent(System.out::println); //dont called

        /* use MAP func Optional<T> -> Optional<U> */
        Engine engine = new Engine("diesel");
        Robot robot = new Robot(engine);
        robot.getEngine().ifPresent(value-> System.out.println(value.getName())); //diesel
        robot.engineNameToUppercase(engine).ifPresent(System.out::println); //DIESEL
        Robot.engineNameToUppercase2(robot).ifPresent(System.out::println); //DIESEL 2

        /* best practice */
        String version1 = Optional
            .ofNullable(new Robot(new Engine("Electrical", new Battery("version 11-333"))))
            .flatMap(Robot::getEngine)
            .flatMap(Engine::getBattery)
            .map(Battery::getVersion)
            .orElse("Battery version is unknown");
        System.out.println("Battery version: " + version1); //version 11-333

        String version11 = Optional
            .ofNullable(new Robot(new Engine("Fuel")))
            .flatMap(Robot::getEngine)
            .flatMap(Engine::getBattery)
            .map(Battery::getVersion)
            .orElse("Battery version is unknown");
        System.out.println("Battery version: " + version11); //Battery version is unknown

    }

    static String getStringValue() {
        return "Hello world";
    }

    static class Engine {
        private final String name;
        private  Battery battery;

        public Engine (String name, Battery battery) {
            this.name = name;
            this.battery = battery;
        }

        Engine (String name) {
            this.name = name;
        }

        public String getName () {
            return name;
        }

        public Optional<Battery> getBattery() {
            return Optional.ofNullable(battery);
        }
    }

    static class Robot {
        private final Engine engine;

        Robot (Engine engine) {
            this.engine = engine;
        }

        public Optional<Engine> getEngine() {
            return Optional.ofNullable(engine);
        }

        public Optional<String> engineNameToUppercase(Engine engine) {
            return Optional.ofNullable(engine).map(it -> it.getName().toUpperCase());
        }

        public static Optional<String> engineNameToUppercase2(Robot robot) {
            return Optional
                .ofNullable(robot)
                .flatMap(Robot::getEngine)
                .map(engine1 -> engine1.getName().toUpperCase() + " 2");
        }
    }

    static class Battery {
        private String version;

        public Battery (String version) {
            this.version = version;
        }

        public Battery () {
        }

        public String getVersion() {
            return version;
        }
    }
}
