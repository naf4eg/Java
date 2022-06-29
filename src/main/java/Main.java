import java.util.Arrays;
import java.util.Locale;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Function<String, Double> parseDouble = Double::parseDouble;
        BiFunction<String, Locale, String> stringLocaleStringBiFunction = String::toLowerCase;
        Function<Long, Double> converter = Long::doubleValue;
        converter.apply(4L);
    }
}
