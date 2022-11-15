package Executors;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo {
    public static void show(){
        // Run a code in asynchronous or a non-blocking fashion
        Runnable task = () -> System.out.println("A");
        var future = CompletableFuture.runAsync(task); // with CompletableFuture we don't really
        // need to create an executor, submit a task to it and finally shutdown CompletableFuture dones
        // this own its own
    }
}
