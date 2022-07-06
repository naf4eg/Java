package func.task14_monads;

public class Main {
    public static void main (String[] args) {
        Calculator.of(10) // inits calculator with the default value 10
                  .consume(System.out::println)  // shows the current value 10
                  .eval(value -> value * 10)     // evaluates a new expression: 100
                  .eval(value -> value + 5)      // evaluates a new expression: 105
                  .consume(System.out::println)  // shows the current value 105
                  .eval(value -> value / 0)      // provokes an error
                  .consume(System.out::println); // doesn't print anything

        Calculator.of((Integer) null) // inits calculator with null as the default value
                  .eval(value -> value * 10)     // doesn't evaluate anything
                  .eval(value -> value + 5)      // doesn't evaluate anything
                  .consume(System.out::println); // doesn't print anything

        Calculator.of(10) // init calculator with the default value 10
                  .eval(value -> value + 5)      // evaluates a new expression: 15
                  .consume(System.out::println)  // shows the current value 15
                  .eval(value -> null) // makes the value null
                  .consume(System.out::println); // doesn't print anything
    }
}
