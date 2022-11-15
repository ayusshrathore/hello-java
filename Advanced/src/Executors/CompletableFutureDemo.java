package Executors;

import java.util.concurrent.CompletableFuture;
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
    }
}
