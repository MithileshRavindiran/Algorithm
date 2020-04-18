package com.algorithm.InterviewTest;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by mravindran on 17/04/20.
 */
public class Utils {


    private static int counter;

    private static AtomicInteger newCounter = new AtomicInteger();

    private static StringBuffer message;

    private static Object counterLock = new Object();

    private static Object messageLock = new Object();

    private static Object counterDecreementLock = new Object();

    public   synchronized static void inc(){
        //synchronized (counterLock) {
            counter++;
            System.out.println("Increement " + counter);
        //}
    }

    public static void newInc() {
        newCounter.incrementAndGet();
        System.out.println("Increement " + newCounter.intValue());
    }

    public synchronized static void append(String value) {
        synchronized (messageLock) {
            message = message != null ? message.append(value) : new StringBuffer(value);
            System.out.println(message.toString());
        }
    }

    public   synchronized static void decreement(){
        //synchronized (counterDecreementLock) {
            counter--;
            System.out.println("Decreement  " + counter);
        //}
    }

    public   static void decreementNew(){
        newCounter.decrementAndGet();
        System.out.println("Decreement  " + newCounter);
    }




}
