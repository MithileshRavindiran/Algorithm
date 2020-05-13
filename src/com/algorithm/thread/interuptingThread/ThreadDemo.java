package com.algorithm.thread.interuptingThread;


/**
 * Created by mravindran on 16/04/20.
 */
public class ThreadDemo {

    public static void main(String args[])  {
        System.out.println(Thread.currentThread().getName());

        Thread t1 = new Thread(new DownloadingFileTask());
        t1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.interrupt();

    }
}
