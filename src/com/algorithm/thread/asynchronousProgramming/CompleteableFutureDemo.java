package com.algorithm.thread.asynchronousProgramming;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Supplier;

/**
 * Created by mravindran on 19/04/20.
 */
public class CompleteableFutureDemo {

    public static void shouw() {
        CompletableFuture<Void> value  =CompletableFuture.runAsync(()-> {
            System.out.println("a");
        });

        Supplier<Integer> task = () -> 1;
        CompletableFuture<Integer> value1  =  CompletableFuture.supplyAsync(task);
        try {
            System.out.println(value1.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
