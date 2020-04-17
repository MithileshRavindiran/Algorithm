package com.algorithm.waitNotify;

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

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int  i =0; i  < 1_000_000; i++) {
            if (Thread.currentThread().isInterrupted()) return;
            status.increementTotalBytes();
        }

        status.done();
        status.notify();

        System.out.println("Downloading the File Stopped: "+ Thread.currentThread().getName());
    }

    public DownloadStatus getStatus() {
        return status;
    }

    public void setStatus(DownloadStatus status) {
        this.status = status;
    }

}
