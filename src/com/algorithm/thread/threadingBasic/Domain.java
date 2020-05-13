package com.algorithm.thread.threadingBasic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by mravindran on 05/05/20.
 */
public class Domain {

    static AtomicInteger  i =  new AtomicInteger() ;

    public static void increement() {
        for (int j =0 ; j < 10_000 ; j++) {
            i.incrementAndGet();
        }
    }

}
