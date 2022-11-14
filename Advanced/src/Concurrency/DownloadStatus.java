package Concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DownloadStatus {
    private int totalBytes;
    private Lock lock = new ReentrantLock();

    public int getTotalBytes() {
        return totalBytes;
    }
    public void incrementTotalBytes(){
        lock.lock();
        try{
            totalBytes++; // non atomic operation
        }
        finally {
            lock.unlock();
        }
    }
}
