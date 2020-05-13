package com.algorithm.thread.executors;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by mravindran on 17/04/20.
 */
public class ExecutorClase {

    public static void main(String args[]) throws ExecutionException, InterruptedException {
        ExecutorService executors = Executors.newFixedThreadPool(2);
        try {
            System.out.println(Thread.currentThread().getName());
            for (int i = 0; i < 2; i++) {
                executors.submit(() -> {
                    System.out.println(Thread.currentThread().getName());
                });
            }

            Future<Integer> future =  null;
            for (int i = 0; i < 2; i++) {
                 future = executors.submit(() -> {
                    LongTask.simulate();
                    return 1;
                });
            }
            System.out.println(future.get());
        }finally {
            executors.shutdown();
        }



    }
}
