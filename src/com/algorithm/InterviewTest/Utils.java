package com.algorithm.InterviewTest;

/**
 * Created by mravindran on 17/04/20.
 */
public class Utils {


    private static int counter;

    private static StringBuffer message;

    private static Object counterLock = new Object();

    private static Object messageLock = new Object();

    public  static void inc(){
        synchronized (counterLock) {
            counter++;
            System.out.println(counter);
        }
    }

    public static void append(String value) {
        synchronized (messageLock) {
            message = message != null ? message.append(value) : new StringBuffer(value);
            System.out.println(message.toString());
        }
    }


}
