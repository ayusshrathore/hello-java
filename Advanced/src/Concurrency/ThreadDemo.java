package Concurrency;

public class ThreadDemo {
    public static void show(){
        // Get the name of currently executing thread
        System.out.println(Thread.currentThread().getName());

        // Illustration for downloading 10 files from the server using 10 different threads
        for(int i = 0; i < 10; i++) {
            // It takes a instance of a class which implements Runnable interface
            Thread thread = new Thread(new DownloadFileTask()); // explicit thread for downloading a file
            thread.start(); // now after starting thread the code of downloading the file from DownloadFileTask
            // will start on a separate thread, each thread performs the operation, completes it and dies so we don't
            // actually have to kill any
        }

    }
}
