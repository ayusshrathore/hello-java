package Concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DownloadStatus {
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
}
