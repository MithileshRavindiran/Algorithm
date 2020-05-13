package com.algorithm.thread.pausingThread;


/**
 * Created by mravindran on 16/04/20.
 */
public class ThreadDemo {

    public static void main(String args[]) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());

        Thread t1 = new Thread(new DownloadingFileTask());
        t1.start();

        for (int i =0 ;  i < 10; i++) {
            Thread t2 = new Thread(new DownloadingFileTask());
            t2.start();
        }
    }
}
