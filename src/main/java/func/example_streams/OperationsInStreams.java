package func.example_streams;

public class OperationsInStreams {
    /*
        Intermediate operations

        limit returns a new stream that consists of the first n elements of this stream;
        skip returns a new stream without the first n elements of this stream;
        distinct returns a new stream consisting of only unique elements according to results of equals;
        sorted returns a new stream that includes elements sorted according to the natural order or a given comparator;
        peek returns the same stream of elements but allows observing the current elements of the stream for debugging;
        filter returns a new stream that includes only the elements that match a given predicate;
        map returns a new stream that consists of the elements obtained by applying a function to each element of the original stream.
        Terminal operations

        count returns the number of elements in the stream as a long value;
        max / min returns maximum / minimum element of the stream as an  Optional  according to the given comparator;
        findFirst / findAny returns the first / any element of the stream as an Optional;
        forEach takes a consumer and applies it to each element of the stream (for example, printing it);
        toArray returns an array of the values in the stream;
        collect returns a collection of the values making up the stream or a complex aggregate value;
        anyMatch returns true if at least one element matches the given predicate (see also: allMatch, noneMatch);
        reduce combines values from the stream into a single value (an aggregate value);
     */
}
