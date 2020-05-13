package com.algorithm.thread.startingThread;

/**
 * Created by mravindran on 16/04/20.
 */
public class DownloadStatus {

    private int totalBytes;

    public int getTotalBytes() {
        return totalBytes;
    }



    public synchronized void increementTotalBytes() {
        totalBytes++;
    }
}
