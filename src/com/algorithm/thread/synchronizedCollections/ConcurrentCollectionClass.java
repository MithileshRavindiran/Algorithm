package com.algorithm.thread.synchronizedCollections;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by mravindran on 17/04/20.
 */
public class ConcurrentCollectionClass {

    public static void main(String args[]) {

        Map<Integer, String> map = new ConcurrentHashMap<>();
        map.put(1, "a");
        map.get(1);
        map.remove(1);
    }
}
