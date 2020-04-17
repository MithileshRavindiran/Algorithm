package com.algorithm.Codility_Lesson5;

/**
 * Created by mravindran on 17/04/20.
 */
public class Divisible {

    public static void main(String args[]) {
        divisible(11, 345,  17);
    }

    private static void divisible(int A, int B, int K) {
        int b = B/K;
        int a = (A > 0 ? (A - 1)/K: 0);
        if(A == 0){
            b++;
        }
        System.out.println(b - a);


    }
}
