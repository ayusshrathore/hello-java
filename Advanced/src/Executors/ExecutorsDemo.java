package Executors;

import java.util.concurrent.Executors;

public class ExecutorsDemo {
    public static void show(){
        var executor = Executors.newFixedThreadPool(2);

        try {
            executor.submit(() ->
                    System.out.println(Thread.currentThread().getName()));
        }finally {
            executor.shutdown(); // Since the thread pool doesn't shut down on its own we do need to
            // explicitly shutdown to terminate our program, it doesn't terminate the current task but
            // stop receiving new ones & wait for them to finish in order to force shutdown tasks we can
            // use executor.shutdownNow() method
        }
    }
}
