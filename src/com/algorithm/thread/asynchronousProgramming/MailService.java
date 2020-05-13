package com.algorithm.thread.asynchronousProgramming;

import com.algorithm.thread.executors.LongTask;

import java.util.concurrent.CompletableFuture;

/**
 * Created by mravindran on 19/04/20.
 */
public class MailService {

    public void  send() throws InterruptedException {
        LongTask.simulate();
        System.out.println("Mail was sent");
    }

    public CompletableFuture<Void> sendAsyc() {
        return CompletableFuture.runAsync(()-> {
            try {
                send();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}