package Streams;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsDemo {
    public static void show() {
        // Functional vs Imperative Programming
        List<Movie> movies = List.of(
                new Movie("a", 10, Genre.ACTION),
                new Movie("a", 10, Genre.ACTION),
                new Movie("b", 20, Genre.THRILLER),
                new Movie("c", 30, Genre.COMEDY)
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

        // Getting unique elements from streams
        movies.stream().map(Movie::getLikes)
                .distinct()
                .forEach(System.out::println);

        // Peeking elements in stream, enables us to get o/p of each operation
        movies.stream()
                .filter(movie -> movie.getLikes() > 10)
                .peek(m -> System.out.println("filtered: " + m.getTitle())) // intermediate operation can be used to build processing pipeline
                .map(Movie::getTitle)
                .peek(t -> System.out.println("mapped: " + t))
                .forEach(System.out::println);


        // Simple Reducers
        // count
        movies.stream().count();
        // anyMatch
        var res = movies.stream().anyMatch(movie -> movie.getLikes() > 20);
        System.out.println(res);
        // allMatch
        var res1 = movies.stream().allMatch(movie -> movie.getLikes() > 20);
        System.out.println(res1);
        // notMatch
        var res2 = movies.stream().noneMatch(movie -> movie.getLikes() > 20);
        System.out.println(res2);
        // findFirst it's return type is Optional<Movie> optional classes prevents us from getting NullPointerExceptions
        var res3 = movies.stream().findFirst().get();
        System.out.println(res3.getTitle());
        // findAny
        var res4 = movies.stream().findAny().get();
        System.out.println(res4.getTitle());
        // max or min
        var res5 = movies.stream().max(Comparator.comparing(Movie::getTitle)).get();
        System.out.println(res5.getTitle());
        var res6 = movies.stream().min(Comparator.comparing(Movie::getTitle)).get();
        System.out.println(res6.getTitle());

        // General purpose reduction operation, gives more control over reducing the streams
        // Optional<Integer> sum = movies.stream().map(Movie::getLikes).reduce((a, b) -> a + b);
        Optional<Integer> sum = movies.stream().map(Movie::getLikes).reduce(Integer::sum);
        // working: after map method we would have stream of likes as [10,20,30]
        // then we would calculate the sum of first 2 indexes [30,30] then at the end we would en up with the
        // result [60], job of this accumulator is to accumulate values
        // NOw also it return an optional type, so optional classes represents objects which may or may not have a value
        // System.out.println(sum.get()); => this would throw an error if we don't have nay value instead
        System.out.println(sum.orElse(0));

        // another method for sum
        Integer sum1 = movies.stream().map(Movie::getLikes).reduce(0, Integer::sum);
        System.out.println(sum1);

        // Collectors
        var result = movies.stream().filter(movie -> movie.getLikes() > 10).collect(Collectors.toList());
        var result1 = movies.stream().filter(movie -> movie.getLikes() > 10).collect(Collectors.toSet());

        // Title (key), Likes(value)
        var result2 = movies.stream().filter(movie -> movie.getLikes() > 10).collect(Collectors.
               toMap(Movie::getTitle, Movie::getLikes));

        var sumOfLikes = movies.stream().filter(movie ->  movie.getLikes() > 10)
                       .collect(Collectors.summingInt(Movie::getLikes));
        System.out.println(sumOfLikes);

        var summary = movies.stream().filter(movie ->  movie.getLikes() > 10)
             .collect(Collectors.summarizingInt(Movie::getLikes));
        System.out.println(summary);

        // joining
        var mapLikesWithTitle = movies.stream().filter(movie ->  movie.getLikes() > 10).map(Movie::getTitle)
             .collect(Collectors.joining(", "));
        System.out.println(mapLikesWithTitle);

       // Grouping or classifying data
        var moviesByGenre = movies.stream().
            collect(Collectors.groupingBy(Movie::getGenre));
        System.out.println(moviesByGenre);

        // storing movies by genre inside a set
        var byGenre = movies.stream().
                collect(Collectors.groupingBy(Movie::getGenre, Collectors.toSet()));
        System.out.println(byGenre);

        // counting number of movies in each category
        var countByGenre = movies.stream().
                collect(Collectors.groupingBy(Movie::getGenre, Collectors.counting()));
        System.out.println(countByGenre);

        // joining names of movies
        var result3 = movies.stream().
                collect(Collectors.groupingBy(Movie::getGenre,
                        Collectors.mapping(Movie::getTitle, Collectors.joining(", ")))); //since joining only works on stream
        // of strings so first mapping it with stream of strings & then applying Collectors.joining in order to join
        System.out.println(result3);

        // Partitioning data
        var partitioned = movies.stream().collect(Collectors.partitioningBy(m -> m.getLikes() > 20));
        // joining partitioned movies
        var result4 = movies
                .stream().collect(Collectors.partitioningBy(m -> m.getLikes() > 20, Collectors
                        .mapping(Movie::getTitle, Collectors.joining(", "))));
        System.out.println(result4);

       // Primitive type streams
       // IntStream.generate(), IntStream.iterate(); generate finite or infinite streams
       // IntStream.of() generate stream of arbitrary sequence of objects
       IntStream.range(1, 5).forEach(System.out::println); // upper bound not inclusive
       IntStream.rangeClosed(1, 5).forEach(System.out::println); // upper bound inclusive
       // Note: all other stuff such as mapping, filtering, slicing, collecting etc are same
    }
}