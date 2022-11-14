package Concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DownloadStatus {
    private volatile boolean isDone; // make sure to get the value from main memory instead of cache it ensures
    // that changes to a field is visible across threads
    private int totalBytes;
    private int totalFiles;
    private Object totalBytesLock = new Object();
    private Object totalFilesLock = new Object();

    public int getTotalBytes() {
        return totalBytes;
    }
    public void incrementTotalBytes(){
        synchronized (totalBytesLock){
            totalBytes++; // non atomic operation
        }
    }
    public void incrementTotalFiles(){
        synchronized (totalFilesLock){
            totalFiles++;
        }
    }
    public int getTotalFiles() {
        return totalFiles;
    }

    public boolean isDone() {
        return isDone;
    }

    public void done() {
        isDone = true;
    }
}
