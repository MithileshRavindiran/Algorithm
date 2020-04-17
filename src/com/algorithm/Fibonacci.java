package com.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mravindran on 16/04/20.
 */
public class Fibonacci {

    public static void main(String[] args) {
        //fibonacciSeries(7);
        fibonacciSeriesTillNum(8);
    }

    private static void fibonacciSeriesTillNum(int finalNum) {
        int t1 = 0;
        int t2 = 1;
        List<Integer> fibNumbers  = new ArrayList<>();
        fibNumbers.add(t1);
        fibNumbers.add(t2);
        while (t2 <= finalNum) {
            int sum = t1 + t2;
            if (sum < finalNum)
            fibNumbers.add(sum);

            t1 = t2;
            t2 = sum;
        }
        fibNumbers.forEach(System.out::println);
    }

    private static void fibonacciSeries(int num) {
        List<Integer> fibonacciSeries = new ArrayList<>();
        for (int i =0 ; i< num; i++) {
            int fibNumber = i;
            if (i > 1) {
                fibNumber =  fibonacciSeries.get(i-1)+fibonacciSeries.get(i-2);
            }
            fibonacciSeries.add(fibNumber);
        }
        fibonacciSeries.forEach(System.out::println);

    }
}
