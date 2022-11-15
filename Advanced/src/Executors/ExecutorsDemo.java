package Executors;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class ExecutorsDemo {
    public static void show(){
        var executor = Executors.newFixedThreadPool(2);

        try {
            // callable which is a just like a runnable which returns a generic type value
            // Its type belong to Future interface which represents future result of an operation
            // which will be calculated in future
            var future = executor.submit(() ->{
                LongTask.simulate();
                return 1;
            });

            // Submit Method won't wait for LongTask & will jump here
            System.out.println("Do more work");
            var result = future.get(); // this method will block the current thread until result of
            // this operation is ready
            System.out.println(result);

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown(); // Since the thread pool doesn't shut down on its own we do need to
            // explicitly shutdown to terminate our program, it doesn't terminate the current task but
            // stop receiving new ones & wait for them to finish in order to force shutdown tasks we can
            // use executor.shutdownNow() method
        }
    }
}
