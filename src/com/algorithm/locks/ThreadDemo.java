package com.algorithm.locks;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by mravindran on 16/04/20.
 */
public class ThreadDemo {

    public static void main(String args[])  {
        System.out.println(Thread.currentThread().getName());

        List<Thread> threadList = new ArrayList<>();
        List<DownloadStatus> downloadStatuses = new ArrayList<>();
        for( int i=0; i< 10; i++) {
            DownloadStatus downloadStatus = new DownloadStatus();
            Thread t1 = new Thread(new DownloadingFileTask(downloadStatus));
            t1.start();
            threadList.add(t1);
            downloadStatuses.add(downloadStatus);
        }

        for (Thread induvidualThread: threadList) {
            try {
                induvidualThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Integer totalBytes = downloadStatuses.stream().map(x -> x.getTotalBytes()).reduce(0, Integer::sum);

        System.out.println(totalBytes);
    }
}
