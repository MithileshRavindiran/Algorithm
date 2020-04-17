package com.algorithm.voltaile;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by mravindran on 16/04/20.
 */
public class ThreadDemo {

    public static void main(String args[]) {
        System.out.println(Thread.currentThread().getName());

        DownloadStatus downloadStatus = new DownloadStatus();
        Thread thread = new Thread(new DownloadingFileTask(downloadStatus));
        Thread thread1 = new Thread(() -> {
            while(!downloadStatus.isDone()) {
            }
            System.out.println(downloadStatus.getTotalBytes());
        });
        thread.start();
        thread1.start();
    }
}
