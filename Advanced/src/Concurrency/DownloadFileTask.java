package Concurrency;

// Runnable interface represents a task to be run on a thread
public class DownloadFileTask implements Runnable{
    private DownloadStatus status;

    public  DownloadFileTask(){
        this.status = new DownloadStatus();
    };

    @Override
    public void run() {
        System.out.println("Downloading a file: " +  Thread.currentThread().getName());

//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        // Simulating long task
        for (int i = 0; i < 10_000; i++) {
            if(Thread.currentThread().isInterrupted()) return; // checking for interrupt request
            status.incrementTotalBytes();
        }

        System.out.println("Download complete: " + Thread.currentThread().getName());
    }

    public DownloadStatus getStatus() {
        return status;
    }
}
