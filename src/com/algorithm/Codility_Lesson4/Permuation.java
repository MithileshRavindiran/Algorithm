package com.algorithm.Codility_Lesson4;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by mravindran on 15/04/20.
 * An array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.

 Your goal is to find that missing element.

 Write a function:

 class Solution { public int solution(int[] A); }

 that, given an array A, returns the value of the missing element.

 For example, given array A such that:

 A[0] = 2
 A[1] = 3
 A[2] = 1
 A[3] = 5
 the function should return 4, as it is the missing element.

 Write an efficient algorithm for the following assumptions:

 N is an integer within the range [0..100,000];
 the elements of A are all distinct;
 each element of array A is an integer within the range [1..(N + 1)].
 */
public class Permuation {

    public static void main(String args[]) {
      int A[] ={2,2,1};
        System.out.println(solution(A));
    }

    public static int permuationCheck(int A[]) {
        ArrayDeque<Integer> sortedNumber = Arrays.stream(A).boxed().collect(Collectors.toCollection(ArrayDeque<Integer>::new));
        int highestNumber = sortedNumber.peek();

        for (int i = highestNumber; i >=1; i--)  {
            if (!sortedNumber.contains(i)) {
                return 0;
            }
        }
      return 1;
    }

    public static int permuationCheckArrayLength(int A[]) {
        Set<Integer> numbers = Arrays.stream(A).boxed().collect(Collectors.toSet());
        int arrayLength = A.length;
        int isPerumatationPossible = 1;
        if (numbers.size() !=  A.length) {
            isPerumatationPossible = 0;
        }else {
            for (int i = arrayLength; i >= 1; i--) {
                if (!numbers.contains(i)) {
                    isPerumatationPossible  = 0;
                    break;
                }
            }
        }
        return isPerumatationPossible;
    }

    public static int solution(int A[])  {
        int expectedInt = 1;
        int missingInt = 0;

        Arrays.sort(A);

        if (A.length > 0) {
            for (int x: A) {
                if (x == expectedInt)
                    expectedInt++;
                else
                    missingInt = expectedInt;
            }
        }else if (A.length == 0) {
            missingInt = 0;
        }

        missingInt  = missingInt >  0 ? 0 : 1;
        return missingInt;
    }


}
