package com.algorithm.interuptingThread;

/**
 * Created by mravindran on 16/04/20.
 */
public class DownloadingFileTask implements Runnable {

    @Override
    public void run() {
        System.out.println("Downloading the File Started: "+ Thread.currentThread().getName());

        for (int  i =0; i  < Integer.MAX_VALUE; i++) {
            if (Thread.currentThread().isInterrupted()) return;
            System.out.println("Downloading Byte "+ i);
        }
        System.out.println("Downloading the File Completed after wait: "+ Thread.currentThread().getName());

    }
}
