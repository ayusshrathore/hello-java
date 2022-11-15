package Executors;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class CompletableFutureDemo {
    public static void show(){
        // Run a code in asynchronous or a non-blocking fashion
        Supplier<Integer> task = () -> 1;
        // If we want a return value we should make use of Supplier interface and pass a supplier instead of
        // a runnable to CompletableFuture
        var future = CompletableFuture.supplyAsync(task);
        // Running code on completion of asynchronous task
        future.thenRun(() -> System.out.println("Done"));
        // with CompletableFuture we don't really
        // need to create an executor, submit a task to it and finally shutdown CompletableFuture dones
        // this own its own
        try {
            var result = future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
