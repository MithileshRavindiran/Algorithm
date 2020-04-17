package com.algorithm.domain;

/**
 * Created by mravindran on 02/04/20.
 */
public class BinaryConversion {

    public static void main(String args[]) {
        int number = 9;
        int maxContinuousZeros = 0;

        String binaryNumber = findBinaryNumber(number);
        int binaryNumberLength = binaryNumber.toCharArray().length;
        int indexOfLast1 = findIndexOfLastOne(binaryNumber, binaryNumberLength);
        int continuousZeros = 0;

        if (indexOfLast1 > 0) {
            for (int i = 1; i < indexOfLast1; i++) {
                if ('0' == binaryNumber.charAt(i)) {
                    if (continuousZeros >= maxContinuousZeros) {
                        continuousZeros++;
                        maxContinuousZeros = continuousZeros;
                    }
                } else {
                    continuousZeros = 0;
                }

            }
        }

        System.out.print(maxContinuousZeros);

        int[] numbers = {3, 8, 9, 7, 6};
        numbers = solution(numbers, 3);


    }

    private static int findIndexOfLastOne(String binaryNumber, int binaryNumberLength) {
        for (int i = binaryNumberLength - 1; i >= 0; i--) {
            if ('1' == binaryNumber.charAt(i)) {
                return i;
            }
        }
        return 0;
    }

    private static String findBinaryNumber(int number) {
        return Integer.toBinaryString(number);
    }

    public static int[] solution(int[] A, int K) {

        K = K%A.length;
        //[3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]
        //[6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]
        //[7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]
        while (K !=0) {
            rotateRight(A);
            K--;
        }

        return A;
    }


    private static void rotateRight(int[] A) {
        int i,tmp;
        int arraySize = A.length;
        tmp = A[arraySize-1];
        for (i = arraySize-2; i >= 0; i--) {
            A[i+1] = A[i];
        }
        A[i+1] = tmp;
    }


}

