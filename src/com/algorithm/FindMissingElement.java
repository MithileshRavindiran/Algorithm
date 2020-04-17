package com.algorithm;

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
}
