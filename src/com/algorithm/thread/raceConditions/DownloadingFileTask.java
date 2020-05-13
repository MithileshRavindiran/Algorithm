package com.algorithm.thread.raceConditions;

/**
 * Created by mravindran on 16/04/20.
 */
public class DownloadingFileTask implements Runnable {

    private DownloadStatus status;

    public DownloadingFileTask(DownloadStatus status) {
        this.status = status;
    }

    @Override
    public void run() {
        System.out.println("Downloading the File Started: "+ Thread.currentThread().getName());

        for (int  i =0; i  < 10_000; i++) {
            if (Thread.currentThread().isInterrupted()) return;
            status.increementTotalBytes();
        }

    }
}
