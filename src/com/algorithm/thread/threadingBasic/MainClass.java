package com.algorithm.thread.threadingBasic;

import com.algorithm.thread.raceConditions.ThreadDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mravindran on 05/05/20.
 */
public class MainClass {


    public static void main(String  args[]) {
        List<Thread> threadList = new ArrayList<>();
        for (int j=0; j<10; j++) {
            Thread myThread =  new Thread(
                    () -> {
                        Domain.increement();
                    }
            );
            myThread.start();
            threadList.add(myThread);
        }

        for (Thread newThread : threadList) {
            try {
                newThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Domain.i);
    }
}
