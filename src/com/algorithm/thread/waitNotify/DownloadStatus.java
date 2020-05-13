package com.algorithm.thread.waitNotify;

/**
 * Created by mravindran on 16/04/20.
 */
public class DownloadStatus {

    private int totalBytes;

    private int totalFiles;

    private volatile boolean isDone;

    private Object  totalBytesLock   = new Object();

    private Object totalFileLock = new Object();


    public int getTotalFiles() {
        return totalFiles;
    }

    public int getTotalBytes() {
        return totalBytes;
    }



    public void increementTotalBytes() {
        synchronized (totalBytesLock) {
            totalBytes++;
        }
    }

    public void increementTotalFiles() {
        synchronized (totalFileLock) {
            totalFiles++;
        }
    }

    public  boolean isDone() {
        return isDone;
    }

    public  void done() {
        isDone = true;
    }
}
