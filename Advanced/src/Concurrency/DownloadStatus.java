package Concurrency;

public class DownloadStatus {
    private int totalBytes;


    public int getTotalBytes() {
        return totalBytes;
    }
    public void incrementTotalBytes(){
        totalBytes++; // non atomic operation
    }
}
