package com.algorithm.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by mravindran on 16/04/20.
 */
public class DownloadStatus {

    //AtomicInteger does Compare and Swap
    private AtomicInteger totalBytes = new AtomicInteger();



    public int getTotalBytes() {
        return totalBytes.get();
    }



    public void increementTotalBytes() {
            totalBytes.incrementAndGet();
    }

}
