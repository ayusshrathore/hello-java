package Streams;

import java.util.List;
import java.util.stream.Stream;

public class StreamsDemo {
    public static void show() {
        // Functional vs Imperative Programming
        List<Movie> movies = List.of(
                new Movie("a", 10),
                new Movie("b", 20),
                new Movie("c", 30)
        );
        // Imperative programming, in which statements specify how something need to be done
        int count = 0;
        for(var movie : movies)
            if(movie.getLikes() > 10) count++;

        // Functional programming is typically a declarative programming but it bring some
        // additional concepts
        // Composing functions to express complex logic (Declarative programming)
       var count1 = movies.stream()
                       .filter(movie -> movie.getLikes() > 10)
                       .count();


        movies.stream().map(movie -> movie.getTitle())
                .forEach(name -> System.out.println(name));

        // FlatMap
        // Flattening Stream<List<x>> -> Stream<x>
        var stream = Stream.of(List.of(1,2,3), List.of(4,5,6));
        stream.flatMap(list -> list.stream()).
                forEach(num -> System.out.println(num));
    }

}