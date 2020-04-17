package com.algorithm.synchronizedKeyWord;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by mravindran on 16/04/20.
 */
public class DownloadStatus {

    private int totalBytes;

    private int totalFiles;

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
}
