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

            // Joining thread (for e.g. scanning for viruses) in order to wait for all threads to download file
            try {
                thread.join(); // by this we tell the current thread to wait for completion of another thread
                // also for a desktop or mobile phone main thread is responsible for handling mouse clicks and keystrokes
                // while it waiting for another thread it will not respond to such events anymore, so UI will freeze
                // & user won't be able to resize or move application anyhow
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("File is ready to be scanned.");
        }

        // If we started downloading large number of files concurrently than our actual thread count than jvm has a thread
        // scheduler job of this scheduler is to decide what threads to run for how long, by giving a slice to cpu to
        // each thread and switching between them, this happens so quickly that it give us illusion of this happening
        // in parallel
    }
}
