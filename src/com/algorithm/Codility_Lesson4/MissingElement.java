package com.algorithm.Codility_Lesson4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by mravindran on 13/04/20.
 */
public class MissingElement {

    public static void main(String args[]) {
        int[] A = {2,3,1,4};
        int element  = findMissingElement(A);
        int missingElement  = getMissingNo(A, A.length);
        System.out.println(missingElement);
        System.out.println(element);
    }

    private static int findMissingElement(int[] A) {

        int arrayMaxElement = A.length + 1;
        List<Integer> listOfIntegers =  Arrays.stream(A).boxed().collect(Collectors.toList());
        for (int i =1; i <= arrayMaxElement;  i++ ) {
            if (!listOfIntegers.contains(i)) {
                return i;
            }
        }
        return 0;
    }

    static int getMissingNo(int a[], int n)
    {
        int i, total;
        total = (n + 1) * (n + 2) / 2;
        for (i = 0; i < n; i++)
            total -= a[i];
        return total;
    }
}
