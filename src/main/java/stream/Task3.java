package stream;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Task3 {
    public static void main (String[] args) {
        String str = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sodales consectetur purus at faucibus. Donec mi quam, tempor vel ipsum non, faucibus suscipit massa. Morbi lacinia velit blandit tincidunt efficitur. Vestibulum eget metus imperdiet sapien laoreet faucibus. Nunc eget vehicula mauris, ac auctor lorem. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer vel odio nec mi tempor dignissim.";
        String str2 = "Мама мыла-мыла-мыла раму!";

        var s = (new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8))).lines()
//                                                                                              .flatMap(str23 -> str23.split(
//                                                                                                  "[^a-zA-Zа-яА-Я0-9']+"))
//                                                                                              .map(String::toLowerCase)
                                                                                              .peek(System.out::println)
                                                                                              .collect(Collectors.groupingBy(
                                                                                                  Function.identity(),
                                                                                                  Collectors.counting()
                                                                                              ));

        s.forEach((ff, lng) -> System.out.println(ff));

        // System.out.println(s);
    }
}
