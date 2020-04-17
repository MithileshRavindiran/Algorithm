package com.algorithm.adders;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

/**
 * Created by mravindran on 16/04/20.
 */
public class DownloadStatus {

    //keeps an aray on demand
    private LongAdder totalBytes = new LongAdder();



    public int getTotalBytes() {
        return totalBytes.intValue();
    }



    public void increementTotalBytes() {
            totalBytes.increment();
    }

}
