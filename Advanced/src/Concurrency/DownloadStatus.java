package Concurrency;


import java.util.concurrent.atomic.AtomicInteger;

public class DownloadStatus {
    private AtomicInteger totalBytes = new AtomicInteger();
    private int totalFiles;

    public int getTotalBytes() {
        return totalBytes.get();
    }
    public void incrementTotalBytes(){
            totalBytes.getAndIncrement(); // atomic operation performed by cpu using a technique called compare & swap
    }
    public void incrementTotalFiles(){
            totalFiles++;
    }
    public int getTotalFiles() {
        return totalFiles;
    }
}
