package com.algorithm.InterviewTest;

/**
 * Created by mravindran on 17/04/20.
 */
public class TestClass {

    public static void  main(String args[]) {

        for (int i =0; i< 10; i++) {
            Thread thread = new Thread(() -> {
                Utils.inc();
            });
//            final String value = String.valueOf(i);
//            Thread thread1 = new Thread(() -> {
//                Utils.append("Value "+value);
//            });
            Thread thread2 = new Thread(() -> {
                Utils.decreement();
            });
            thread2.start();
            thread.start();
            //thread1.start();

        }


    }
}
