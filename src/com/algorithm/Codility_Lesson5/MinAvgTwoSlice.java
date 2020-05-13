package com.algorithm.Codility_Lesson5;

/**
 * Created by mravindran on 01/05/20.
 */
public class MinAvgTwoSlice {

    public static void main(String[] args) {
        // int[] A = new int[] { 2, 2, 1, 2, 1, 2 };
        // int[] A = new int[] { 7, 1, 3, 2, 5, 1, 6, 3 };
        // int[] A = new int[] { 2, 2, 1, 2, 1 };
        int[] A = new int[] { 4, 2, 2, 5, 1, 5, 8 };
        int solution = new MinAvgTwoSlice().solution(A);
        System.out.println(solution);
    }

    public int solution(int[] A) {
        // write your code in Java SE 7

        int minS = -1;
        double minAvg = Double.MAX_VALUE;
        for (int i = 0; i < A.length - 1; i++) {
            double avg = (A[i] + A[i + 1]) / 2d;
            if (avg < minAvg) {
                minS = i;
                minAvg = avg;
            }
            if (i + 2 < A.length) {
                avg = (A[i] + A[i + 1] + A[i + 2]) / 3d;
                if (avg < minAvg) {
                    minS = i;
                    minAvg = avg;
                }

            }

        }
        return minS;

    }
}
