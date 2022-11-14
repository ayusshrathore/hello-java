package Concurrency;

// Runnable interface represents a task to be run on a thread
public class DownloadFileTask implements Runnable{
    @Override
    public void run() {
        System.out.println("Downloading a file: " +  Thread.currentThread().getName());
    }
}
