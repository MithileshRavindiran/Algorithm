package com.algorithm.pausingThread;

/**
 * Created by mravindran on 16/04/20.
 */
public class DownloadingFileTask implements Runnable {

    @Override
    public void run() {
        System.out.println("Downloading the File Started: "+ Thread.currentThread().getName());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Downloading the File Completed after wait: "+ Thread.currentThread().getName());

    }
}
