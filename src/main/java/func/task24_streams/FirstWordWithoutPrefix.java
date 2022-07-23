package func.task24_streams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Here you need to implement a method named printFirstWordWithoutPrefix that takes a list of words and a prefix and prints the first word that doesn't start from the prefix. If the suitable word is not found, the method shouldn't print anything.
 * <p>
 * Sample Input:
 * bitcoin bitrix bytecode bingo
 * bit
 * <p>
 * Sample Output:
 * bytecode
 */
public class FirstWordWithoutPrefix {

    public static void printFirstWordWithoutPrefix (List<String> words, String prefix) {
        words.stream()
             .filter(s -> !s.contains(prefix))
             .findFirst()
             .ifPresent(System.out::println);
    }

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> words = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        String prefix = scanner.nextLine();
        printFirstWordWithoutPrefix(words, prefix);
    }
}
