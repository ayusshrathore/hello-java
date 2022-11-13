package Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

public class CreatingStreamsDemo {
    public static void show(){
        // from collection interface
        Collection<Integer> x = new ArrayList<>();
        x.stream();

        // from list interface
        var list = new ArrayList<>();
        list.stream();

        // from Arrays utility class
        int[] arr = {1, 2, 3};
        Arrays.stream(arr).forEach(n -> System.out.println(n));

        //from arbitrary number of objects
        Stream.of(1,2,3,4,5,6);

        // Infinite or Finite streams
        var stream = Stream.generate(() -> Math.random()); // this would generate infinite stream of random numbers
        // this is something we can't do with collections as we can't just store infinite number of random
        // numbers we would just ran out of memory, the numbers would generate everytime we read a number from
        // the stream they will not just get generated ahead of time this is termed as lazy evaluation

        // passing the consumer will work
        stream.limit(3).forEach(n -> System.out.println(n));

        // Another method to generate finite or infinite streams
        Stream.iterate(1, n -> n+1).limit(10).forEach(n -> System.out.println(n)); // this would too generate a infinite stream
    }
}
