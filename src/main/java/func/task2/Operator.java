package func.task2;

import java.util.function.BiFunction;

//Write a lambda expression that accepts two integer arguments and returns the minimum of them and
// then assign the lambda expression to the function variable. Don't forget to add the ;
// character on the end.
//Sample Input: 7 6
//Sample Output: 6
public class Operator {

    static BiFunction<Integer, Integer, Integer> function = (a, b) -> a < b ? a : b;
}
