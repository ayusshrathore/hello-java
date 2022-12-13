package Executors;

// Executors -> A framework to manage threads (creation, assigning tasks, etc...) rather than explicitly
// handling them, so we do not need to perform any thread manipulation on our own & let java's executor framework
// handle that
// But Executor framework doesn't protect us from concurrency issues such as Race condition & visibility problem

public class Main {
    public static void main(String[] args) {
        ExecutorsDemo.show();
        CompletableFutureDemo.show();

        // Asynchronous API demo
        var service = new MailService(); // This is a synchronous or a blocking code
        // so we won't be able to see the print statement below until send() method is completes its job
        service.sendAsync(); // they don't block the current thread and better exploit the parallel hardware
        System.out.println("Hello World");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
