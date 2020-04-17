package com.algorithm.Codility_Lesson4;

/**
 * Created by mravindran on 13/04/20.
 */
public class FrogRiverOne {

    public static void main(String args[]) {

        int[] A = {1, 3,1,4,2,3,4,5};
        int value = frog(5, A);

        System.out.println(value);
    }


    public static int frog(int X, int[] A) {
        int steps = X;
        boolean[] bitmap = new boolean[steps + 1];
        for (int i = 0; i < A.length; i++) {
            if (!bitmap[A[i]]) {
                bitmap[A[i]] = true;
                steps--;
                if (steps == 0) return i;
            }

        }
        return -1;
    }
}