package Concurrency;

public class ThreadDemo {
    public static void show(){
        // Get the name of currently executing thread
        System.out.println(Thread.currentThread().getName());

        // Illustration for downloading 10 files from the server using 10 different threads in parallel
        for(int i = 0; i < 10; i++) {
            // It takes a instance of a class which implements Runnable interface
            Thread thread = new Thread(new DownloadFileTask()); // explicit thread for downloading a file
            thread.start(); // now after starting thread the code of downloading the file from DownloadFileTask
            // will start on a separate thread, each thread performs the operation, completes it and dies, so we don't
            // actually have to kill any
        }

        // If we started downloading large number of files concurrently than our actual thread count than jvm has a thread
        // scheduler job of this scheduler is to decide what threads to run for how long, by giving a slice to cpu to
        // each thread and switching between them, this happens so quickly that it give us illusion of this happening
        // in parallel

    }
}
