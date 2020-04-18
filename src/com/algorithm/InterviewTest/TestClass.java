package com.algorithm.InterviewTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mravindran on 17/04/20.
 */
public class TestClass {

    public static void  main(String args[]) {

        List<Thread> threadList = new ArrayList<>();

        for (int i =0; i< 10; i++) {
            Thread thread = new Thread(() -> {
                Utils.inc();
            });
          final String value = String.valueOf(i);
            Thread thread1 = new Thread(() -> {
                Utils.append("Value "+value);
            });
            Thread thread2 = new Thread(() -> {
                Utils.decreement();
            });

            Thread thread3= new Thread(() -> {
                Utils.newInc();
            });

            Thread thread4 = new Thread(() -> {
                Utils.decreementNew();
            });
            //thread2.start();
            //thread.start();
            //threadList.add(thread3);
            ;
            threadList.add(thread3);
           thread3.start();
           //thread4.start();
            //thread1.start();

        }

        for (Thread thread: threadList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
