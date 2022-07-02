package func.task1_функ_интерфейс;

@FunctionalInterface
interface BinaryFunction <ONE,TWO,RESULT> {
    // write your code here
    RESULT apply(ONE arg1, TWO arg2);
}
