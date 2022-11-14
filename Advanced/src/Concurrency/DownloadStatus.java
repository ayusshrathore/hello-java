package Concurrency;


import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

public class DownloadStatus {
    // Having multiple threads updating a value frequently it's better to use adder class being faster than atomic types
    private LongAdder totalBytes = new LongAdder();

    public int getTotalBytes() {
        return totalBytes.intValue();
    }
    public void incrementTotalBytes(){
            totalBytes.increment(); // atomic operation performed by cpu using a technique called compare & swap
    }
}
