package Streams;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
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

        // Filtering streams
        // Termination or terminal operation with streams
        Predicate<Movie> isPopular = movie -> movie.getLikes() > 10;
        movies.stream().filter(isPopular).forEach(movie -> System.out.println(movie.getTitle()));

        // Slicing Streams
        // limit
        movies.stream().limit(2).forEach(movie -> System.out.println(movie));
        // skip
        movies.stream().skip(2).forEach(movie -> System.out.println(movie));

        // illustration (pagination)
        // 1000 movies
        // 10 per page
        // skip(20) = skip((page - 1) x pageSize)
        // limit(10) = limit(pageSize)
        movies.stream().skip(20).limit(10).forEach(movie -> System.out.println(movie));

        // takeWhile & dropWhile
        // it stops exactly when an predicate returns false
        movies.stream().takeWhile(movie -> movie.getLikes() > 30).forEach(movie -> System.out.println(movie));

        // Sorting streams
        movies.stream().sorted((a, b) -> a.getTitle().compareTo(b.getTitle())).forEach(m-> m.getTitle());
        // another method
        movies.stream().sorted(Comparator.comparing(Movie::getTitle)).forEach(m -> System.out.println(m));
        // reverse stream
        movies.stream().sorted(Comparator.comparing(Movie::getTitle).reversed()).forEach(m -> System.out.println(m));

    }

}