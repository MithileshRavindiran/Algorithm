package com.algorithm;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by mravindran on 15/04/20.
 */
public class NumberDivisible {

    public static void main(String args[])  {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        System.out.println(divsible(6, 18, 3));
    }

    public static int divsible(int  a,  int b, int divisble) {
        /*int numberOfDivisible = 0;
        for (int i = a; i <=  b; i++) {
            if (i % divisble == 0)
                numberOfDivisible++;
        }
        return numberOfDivisible;*/
        int B= b/divisble;
        int A = (a > 0 ? (a - 1)/divisble: 0);
        if(a == 0){
            B++;
        }
        return B - A;
    }

}
