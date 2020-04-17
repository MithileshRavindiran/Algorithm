package com.algorithm.synchronizedCollections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by mravindran on 17/04/20.
 */
public class SynchronizedCollectionsClass {

    public static void main(String  arg[]) {

        //Normal Collection fails with race conditions
        //Collection<Integer> list = new ArrayList<>();

        Collection<Integer> list = Collections.synchronizedCollection(new ArrayList<>());

        Thread t1= new Thread(() -> {
            list.addAll(Arrays.asList(1,2,3));
        });

        Thread t2= new Thread(() -> {
            list.addAll(Arrays.asList(4,5,6));
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(list);

    }
}
