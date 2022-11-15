package Executors;

import java.util.concurrent.CompletableFuture;

public class MailService {
    public void send(){
        LongTask.simulate();
        System.out.println("Mail was sent.");
    }

    // We can convert a synchronous function into an asynchronous block of code by wrapping it
    // inside a CompletableFuture object
    public CompletableFuture<Void> sendAsync(){
        return CompletableFuture.runAsync(this::send);
    }
}
