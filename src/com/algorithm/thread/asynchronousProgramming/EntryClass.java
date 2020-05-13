package com.algorithm.thread.asynchronousProgramming;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Created by mravindran on 19/04/20.
 */
public class EntryClass {

    private static int toFahreinheit(int celcius) {
        return (int) (celcius * 1.8) + 32;
    }

    public static void main(String args[]) throws InterruptedException {
        //CompleteableFutureDemo.shouw();

        //Normal  Thread this wait till the thread is done
        MailService mailService = new MailService();
        mailService.send();
        System.out.println("Hello  World");

        // Async Thread with CompletableFuture
        MailService mailService1 = new MailService();
        mailService1.sendAsyc();
        System.out.println("Hello  World");
        //this thread is added to make the  thread wait to see the async thread  output
        Thread.sleep(5000);

        CompletableFuture<Integer> result = CompletableFuture.supplyAsync(() -> 1);
        //chaining to run normal
        result.thenRun(() -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("Saved  in Database");
        })
        // chaining to run async
        .thenRunAsync(() ->  {
            System.out.println(Thread.currentThread().getName());
            System.out.println("Done");
        });
        result.thenAccept(x -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println(x);
        });

        //exception handling in completable future
        CompletableFuture<Integer> exception = CompletableFuture.supplyAsync(() -> {
            System.out.println("Inside the getting current weather");
            throw new IllegalStateException();
        });

        try {
           Integer temperature =  exception.exceptionally(ex -> 1).get();
            System.out.println(temperature);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        //conversion in completable future



        CompletableFuture<Integer> tempInFarenheit = CompletableFuture.supplyAsync(() -> 20).thenApply(EntryClass::toFahreinheit);
        try {
            System.out.println(tempInFarenheit.get());
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        CompletableFuture.supplyAsync(() -> 20).thenApply(EntryClass::toFahreinheit).thenAccept(farenhit -> System.out.println(farenhit));


        CompletableFuture
                .supplyAsync(() -> "mithilesh89ece@gmail.com")
                .thenCompose(email -> CompletableFuture.supplyAsync(() -> "playlist"))
                .thenAccept(playlist  -> System.out.println(playlist));


    }

}
