package com.algorithm.Codility_Lesson2;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mravindran on 12/04/20.
 */
public class OddOccurences {

    public static void main(String args[]) {

        int[]  A = {9,3,9,3,9,7,9};

        System.out.println(oddOccurenceCheck(A));

    }


    public static int oddOccurenceCheck(int[] A) {
        // write your code in Java SE 8
        Map<Integer, Integer> mapToFindOdd = new HashMap<>();

        for (int a : A)  {
            int value = mapToFindOdd.get(a) == null ? 1 : mapToFindOdd.get(a)+1;
            mapToFindOdd.put(a, value);
        }

        for (int a: A) {
            if (mapToFindOdd.get(a)%2 != 0)
                return a;
        }

        return 0;
    }
}
