package com.algorithm.Codility_Lesson3;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by mravindran on 15/04/20.
 */
public class FindMissingElement {

    public static void main(String args[]) {
        int A[] = {-1, -2, -3};
        System.out.println(solution(A));
        System.out.println(solution2(A));
        System.out.println(solution1(A));
    }

    public static int solution(int[] A) {
        // write your code in Java SE 8
        int arrayLength = A.length;
        int missingElement  = 1;
        Set<Integer> setOfNumbers =  Arrays.stream(A).boxed().collect(Collectors.toSet());
        for (int i = 1; i <= arrayLength+1; i++) {
           if (!setOfNumbers.contains(i)) {
              return i;
           }

        }

        return missingElement;
    }

    /*1. This solution is not good. If the number is too large, int is overflow. Double or float is not accurate.*/
        public static int solution1(int[] A) {
            // write your code in Java SE 8
            int realSum = 0;
            int N = A.length;
            for (int i=0; i<N;i++){
                realSum = realSum + A[i];
            }
            int originalSum = (N+1)*(N+2)/2;
            return (originalSum - realSum);
        }


        public static int solution2(int[] A)
        {
            for (int i = 0; i < A.length; i++)
            {
                if (A[i] == 0)
                {
                    continue;
                }

                int n = A[i] - 1;
                while (n != -1 && n < A.length)
                {
                    int next = A[n] - 1;
                    A[n] = 0;
                    n = next;
                }
            }

            for (int i = 0; i < A.length; i++)
            {
                if (A[i] != 0)
                {
                    return i + 1;
                }
            }

            return A.length + 1;
        }


/*score : 100%*/
}
