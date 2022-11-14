package Concurrency;

// Runnable interface represents a task to be run on a thread
public class DownloadFileTask implements Runnable{
    private DownloadStatus status;

    public DownloadFileTask(){};

    public  DownloadFileTask(DownloadStatus status){
        this.status = status;
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
        for (int i = 0; i < 1_000_000; i++) {
            if(Thread.currentThread().isInterrupted()) return; // checking for interrupt request
            status.incrementTotalBytes();
        }

        status.done();
        synchronized (status) {
            status.notifyAll(); // notify other threads that state of this object is changes
        }
        System.out.println("Download complete: " + Thread.currentThread().getName());
    }

    public DownloadStatus getStatus() {
        return status;
    }
}
