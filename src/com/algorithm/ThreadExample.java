package com.algorithm;

import com.sun.tools.internal.ws.wsdl.document.soap.SOAPUse;

/**
 * Created by mravindran on 16/04/20.
 */
public class ThreadExample {

    public static void main(String args[]) {
        MainThread mainThread = new MainThread();

         Thread  thread1 = new Thread() {
             String threadValue = "t1";
             public void run(){
                 MainThread.increment(threadValue);
             }
         };

        Thread  thread4 = new Thread() {
            String threadValue = "t4";
            public void run(){
                MainThread.increment(threadValue);
            }
        };

//        Thread  thread3 = new Thread() {
//            String threadValue = "t3";
//            public void run(){
//                MainThread.decrement(threadValue);
//            }
//        };
        for (int i=0; i< 3; i++) {
            Thread  thread2 = new Thread() {
                String threadValue = "t2";
                public void run(){
                    MainThread.increment(threadValue);
                }
            };
            thread2.start();
        }
        //thread3.start();

    }
}
