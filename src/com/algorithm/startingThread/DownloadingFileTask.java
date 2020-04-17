package com.algorithm.startingThread;

/**
 * Created by mravindran on 16/04/20.
 */
public class DownloadingFileTask implements Runnable {

    @Override
    public void run() {
        System.out.println("Downloading the File Started: "+ Thread.currentThread().getName());

    }
}
