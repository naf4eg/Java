package func.task27_streams_collecting_map;

import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Competition {

    public static Map<String, Integer> getTeamPlaceMap(Collection<Team> teams) {
        return teams
            .stream()
            .sorted(Comparator.comparing(Team::getPlace))
            .collect(Collectors.toMap(Team::getName, Team::getPlace, (value1, value2) -> value1 ,LinkedHashMap::new));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Collection<Team> teams = Stream
            .iterate(1, i -> scanner.hasNextLine(), i -> i + 1)
            .map(i -> scanner.nextLine().split("\\s+"))
            .map(parts -> new Team(parts[0], Integer.parseInt(parts[1])))
            .collect(Collectors.toSet());

        getTeamPlaceMap(teams)
            .forEach((team, speaker) -> System.out.println(team + ": " + speaker));
    }
}
