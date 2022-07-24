package func.example_streams;

import java.time.Instant;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectingStreamElements {

    static class Log {
        private final Instant timestamp;
        private final String type;
        private final long delay;

        public Log(Instant timestamp, String type, Long delay) {
            this.timestamp = timestamp;
            this.type = type;
            this.delay = delay;
        }

        public Instant getTimestamp () {
            return timestamp;
        }

        public String getType () {
            return type;
        }

        public long getDelay () {
            return delay;
        }

        @Override
        public String toString () {
            return "Log{" + "timestamp=" + timestamp + ", type='" + type + '\'' + ", delay=" + delay + '}';
        }
    }

    public static void main (String[] args) {

        System.out.println("=============== Collecting toList ================");

        List<Integer> collect = Stream.of(1, 4, 6, 4, 5, 6).collect(Collectors.toList());
        System.out.println(".collect(Collectors.toList()): " + collect);

        System.out.println("=============== Collecting toSet ================");

        Set<Integer> collect1 = Stream.of(1, 4, 6, 4, 5, 6).collect(Collectors.toSet());
        System.out.println(".collect(Collectors.toSet()): " + collect1);

        System.out.println("=============== Collecting toUnmodifiableSet ================");

        Set<Integer> collect2 = Stream.of(1, 4, 6, 4, 5, 6).collect(Collectors.toUnmodifiableSet());
        try { collect2.add(10); } catch (Exception exception) { System.out.println(".collect(Collectors.toUnmodifiableSet()): " + exception.getClass().getSimpleName());}

        System.out.println("=============== Collecting toCollection ================");

        CopyOnWriteArrayList<Integer> collect3 = Stream.of(1, 4, 6, 4, 5, 6).collect(Collectors.toCollection(
            CopyOnWriteArrayList::new));
        System.out.println(".collect(Collectors.toCollection(CopyOnWriteArrayList::new)): " + collect3);

        System.out.println("=============== Collecting toMap ================");


        List<Log> logs = List.of(
            new Log(Instant.now(), "ERROR", 100L),
            new Log(Instant.now(), "WARN", 200L),
            new Log(Instant.now(), "INFO", 300L)
        );
        Map<Instant, Log> instantLogMap = logs.stream().filter(log -> !(log.getType().equals("INFO"))).collect(Collectors.toMap(
            Log::getTimestamp,
            Function.identity()
        ));
        System.out.println("map: " + instantLogMap);

        Collectors.toMap(Log::getTimestamp, Function.identity(), (first, second) -> first); //3 arg use for resolving collision

        Collectors.toMap(Log::getTimestamp, Function.identity(), (first, second) -> first, TreeMap::new); //4arg for implementation Map interfase. By default use HashMap

        System.out.println("=============== Collecting summing, averaging, counting ================");

        long collect4 = logs.stream().collect(Collectors.summingLong(Log::getDelay));
        System.out.println(".collect(Collectors.summingLong(Log::getDelay)): " + collect4);

        Double collect5 = logs.stream().collect(Collectors.averagingLong(Log::getDelay));
        System.out.println(".collect(Collectors.averagingLong(Log::getDelay)): " + collect5);

        Optional<Log> collect6 = logs.stream().collect(Collectors.minBy(Comparator.comparing(Log::getDelay)));
        System.out.println(".collect(Collectors.minBy(Comparator.comparing(Log::getDelay))): " + collect6.get());

        Optional<Log> collect7 = logs.stream().collect(Collectors.maxBy(Comparator.comparing(Log::getDelay)));
        System.out.println(".collect(Collectors.maxBy(Comparator.comparing(Log::getDelay))): " + collect7.get());

        Long collect8 = logs.stream().collect(Collectors.counting());
        System.out.println(".collect(Collectors.counting()): " + collect8);


    }
}
