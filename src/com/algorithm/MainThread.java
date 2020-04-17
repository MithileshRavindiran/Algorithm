package com.algorithm;

/**
 * Created by mravindran on 16/04/20.
 */
public class MainThread {

    private static int count = 0;

    public   synchronized static void increment(String threadValue) {
        count++;
//        if(count==2)
//            count=0;
        System.out.println(Thread.activeCount());
        System.out.println("Increasing Count"  + Thread.currentThread().getName() + " " +count);
    }

    /*public synchronized static void decrement(String threadValue) {
        count--;
        System.out.println("Decreasing Count" + threadValue + " " + count);
    }*/
}
