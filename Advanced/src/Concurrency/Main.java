package Concurrency;

public class Main {
    public static void main(String[] args) {
        // Get active threads
        System.out.println(Thread.activeCount());
        // Get available processors
        System.out.println(Runtime.getRuntime().availableProcessors());

        // Thread Demo
        ThreadDemo.show();
    }
}
