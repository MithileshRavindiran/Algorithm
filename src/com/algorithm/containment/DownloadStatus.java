package com.algorithm.containment;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by mravindran on 16/04/20.
 */
public class DownloadStatus {

    private int totalBytes;

    private Lock lock =  new ReentrantLock();

    public int getTotalBytes() {
        return totalBytes;
    }



    public void increementTotalBytes() {
        lock.lock();
        totalBytes++;
        lock.unlock();
    }
}
