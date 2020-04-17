package com.algorithm.raceConditions;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by mravindran on 16/04/20.
 */
public class ThreadDemo {

    public static void main(String args[])  {
        System.out.println(Thread.currentThread().getName());

        List<Thread> threadList = new ArrayList<>();
        DownloadStatus  downloadStatus = new DownloadStatus();
        for( int i=0; i< 10; i++) {
            Thread t1 = new Thread(new DownloadingFileTask(downloadStatus));
            t1.start();
            threadList.add(t1);
        }

        for (Thread induvidualThread: threadList) {
            try {
                induvidualThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(downloadStatus.getTotalBytes());
    }
}
