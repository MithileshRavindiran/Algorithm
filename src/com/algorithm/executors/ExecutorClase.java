package com.algorithm.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by mravindran on 17/04/20.
 */
public class ExecutorClase {

    public static void main(String args[]) {
        ExecutorService executors = Executors.newFixedThreadPool(2);
        System.out.println(Thread.currentThread().getName());
        for (int i=0; i < 10; i++) {
            executors.submit(() -> {
                System.out.println(Thread.currentThread().getName());
            });
        }

        executors.shutdown();
    }
}
