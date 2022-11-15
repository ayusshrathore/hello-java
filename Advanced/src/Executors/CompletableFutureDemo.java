package Executors;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class CompletableFutureDemo {
    // Since querying a DB is long waiting task we should return CompletableFuture<String> obj
    public static CompletableFuture<String> getUserEmailAsync(){
        return CompletableFuture.supplyAsync(() -> "john@email.com");
    }
    public static CompletableFuture<String> getPlaylistAsync(String email){
        return CompletableFuture.supplyAsync(() -> email + ": Alan-Walker");
    }
    public static int toFahrenheit(int celsius){
        return (int) (celsius * 1.8) + 32;
    }
    public static void show(){
        // Run a code in asynchronous or a non-blocking fashion
        Supplier<Integer> task = () -> 20;
        // If we want a return value we should make use of Supplier interface and pass a supplier instead of
        // a runnable to CompletableFuture
        var future = CompletableFuture.supplyAsync(task); // build a completable future
        // Running code on completion of asynchronous task
        // .thenRunAsync() will execute underlying task on a different thread
        // whereas .thenRun() will execute it on main thread
        // .thenAccept() takes an consumer object
            var result = future.thenApply(CompletableFutureDemo::toFahrenheit); // transform a completable future
            result.thenAccept(System.out::println); // accept or consume a completable future

        // with CompletableFuture we don't really
        // need to create an executor, submit a task to it and finally shutdown CompletableFuture does
        // this own its own

        // Composing Completable Futures
        getUserEmailAsync()
                .thenCompose(CompletableFutureDemo::getPlaylistAsync)
                .thenAccept(System.out::println);

        // Combining completable futures
        var first = CompletableFuture
                .supplyAsync(() -> "20USD")
                .thenApply(str -> {
                    var price = str.replace("USD", "");
                    return Integer.parseInt(price);
                });

        var second = CompletableFuture.supplyAsync(() -> 0.9);

        first.thenCombine(second, (price, exchangeRate) -> price * exchangeRate)
                .thenAccept(System.out::println);


        // Waiting for many tasks
        var task1 = CompletableFuture.supplyAsync(() -> 1);
        var task2 = CompletableFuture.supplyAsync(() -> 2);
        var task3 = CompletableFuture.supplyAsync(() -> 3);

        CompletableFuture.allOf(task1, task2, task3)
                .thenRun(() -> {
                    try {
                        var firstResult = task1.get();
                        var secondResult = task2.get();
                        var thirdResult = task3.get();
                        System.out.println(firstResult + secondResult + thirdResult);
                    } catch (InterruptedException | ExecutionException  e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("ALl tasks executed successfully");
                });

        // waiting for the first task
        var slowWeatherAPI = CompletableFuture.supplyAsync(() -> {
            LongTask.simulate();
            return 20;
        });
        var fastWeatherAPI = CompletableFuture.supplyAsync(() -> 20);

        // wait for completion of one of the completable future completes
        CompletableFuture.anyOf(slowWeatherAPI, fastWeatherAPI)
                .thenAccept(System.out::println);
    }
}
