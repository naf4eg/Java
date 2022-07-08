package func.example_streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

public class SourceStream {
    public static void main (String[] args) {

        /*  A stream can be created from a collection source as you saw before. The collection can be a list, a set or anything else.  */
        List<Integer> degreesOfTwo = List.of(1, 2, 4, 8, 16, 32, 64);
        Stream<Integer> degreesOfTwoStream = degreesOfTwo.stream();

        Set<String> programmingLanguages = Set.of("Java", "Kotlin", "Scala", "Python");
        Stream<String> programmingLanguagesStream = programmingLanguages.stream();

        /* An array can also be used as a source for a stream: */
        Stream<String> stream = Arrays.stream(new String[] { "Java", "Kotlin", "Scala", "Python" });

        /* A stream can be created from a string using the lines method. It returns a Stream<String> object based on the original string separated by line terminators such as \n, \r, and \r\n. */
        Stream<String> stream2 = "Breaking news\na new version of Java\ris coming soon!".lines();
        stream2.forEach(System.out::println);

        /* Sometimes you need a stream created from a Map. Not being a subclass of Collection, it doesn't provide the stream method, but you can create a stream of keys, values or map entries because they are represented as standard sets. */
        Map<String, String> phoneBook = Map.of(
            "Tom Hunter", "0131 128 8144",
            "Layla Graham", "07027296303",
            "Michael Butler", "+44(0)1035 093821"
        );

        Stream<String> names = phoneBook.keySet().stream();
        Stream<String> phones = phoneBook.values().stream();
        Stream<Map.Entry<String, String>> entries = phoneBook.entrySet().stream();

        /* It is also possible to obtain a stream just by enumerating all values and passing them to the static of method. This way is useful for different test and debugging purposes. */
        Stream<String> persons = Stream.of("Elizabeth", "John", "Alise");

        /*  If you have two streams and they types are the same, you can create a third stream by concatenating them. */
        Stream<Integer> stream11 = Stream.of(1, 2, 3);
        Stream<Integer> stream21 = Stream.of(4, 5);
        Stream<Integer> stream31 = Stream.concat(stream11, stream21); // 1 2 3 4 5

        /* Java provides several possibilities to create an empty stream (e.g. to return it from a method). */
        Stream<Integer> empty1 = Stream.of();
        Stream<Integer> empty2 = Stream.empty();

        /*  In addition, you can create a stream from an Optional. */
        Optional<String> str = Optional.ofNullable("book");
        Stream<String> bookStream = str.stream();


    }
}
