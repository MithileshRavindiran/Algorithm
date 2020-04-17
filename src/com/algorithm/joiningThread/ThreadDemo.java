package com.algorithm.joiningThread;


/**
 * Created by mravindran on 16/04/20.
 */
public class ThreadDemo {

    public static void main(String args[])  {
        System.out.println(Thread.currentThread().getName());

        Thread t1 = new Thread(new DownloadingFileTask());
        t1.start();

        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Downloading the File Completed after wait Can start the scanning");
    }
}
