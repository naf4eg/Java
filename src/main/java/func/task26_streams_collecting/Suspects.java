package func.task26_streams_collecting;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Recently there was a high-profile crime in a city. Police found a criminal's torn business card which has "jo" written on it. Detectives suspect that this is a part of the criminal's first or last name.
 * You need to write some code to reduce the number of suspects according to this clue to make the crime investigation much easier. In the resulting list, the suspects must be sorted alphabetically according to their names.
 * It is guaranteed that all names of suspects are given in the lowercase to simplify the data processing.
 *
 * Sample Input:
 * maddox hopper
 * remi joyner
 * martyn wilks
 * jim burks
 * joshua parry
 * mojo milner
 *
 * Sample Output:
 * joshua parry
 * mojo milner
 * remi joyner
 */
public class Suspects {
    public static List<String> reduceSuspects(List<String> suspects) {
        return suspects
            .stream()
            .filter(suspect -> suspect.contains("jo"))
            .sorted()
            .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> suspects = Stream
            .iterate(1, i -> scanner.hasNextLine(), i -> i + 1)
            .map(i -> scanner.nextLine())
            .collect(Collectors.toList());

        reduceSuspects(suspects)
            .forEach(System.out::println);
    }
}
