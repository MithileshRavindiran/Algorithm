package com.algorithm.domain;

import java.util.*;
import java.util.Stack;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by mravindran on 03/04/20.
 */
public class Solution {

    public static void main(String args[]) {
        int value = 3;
        String binaryNumber = getBinarayNumber(value);
        Integer.parseInt(binaryNumber);
        System.out.println(makeAnagram("cde", "dcf"));
        List<Name> integerList  = new ArrayList<>();
        integerList.add(new Name(1, "Mithilesh"));
        integerList.add(new Name(1, "Mithilesh"));
        integerList.add(new Name(1, "Mithilesh"));
        integerList.add(new Name(1, "Mithilesh"));
        integerList.add(new Name(2, "Pavithra"));
        integerList.add(new Name(2, "Pavithra"));
        integerList.add(new Name(3, "Mithra Shri"));
        Map<Name, Long> duplicateTransactions = integerList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        duplicateTransactions.size();
        int[] bubbleSortNumber ={8,2,4,1,3,9,5};
        bubbleSort(bubbleSortNumber);
        int[] selectionSortNumber ={8,2,4,1,3,9,5};
        selectionSort(selectionSortNumber);
        int[] insertionSortNumber ={8,2,4,1,3,9,5};
        insertionSort(insertionSortNumber);
        System.out.println(Arrays.toString(bubbleSortNumber));
        System.out.println(Arrays.toString(selectionSortNumber));
        System.out.println(Arrays.toString(insertionSortNumber));
    }

    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++)
                if (array[j] < array[minIndex])
                    minIndex = j;
            swap(array, minIndex, i);
        }
    }


    public static void bubbleSort(int[] array) {
        boolean isSorted;
        for (int i = 0; i < array.length; i++) {
            isSorted = true;
            for (int j = 1; j < array.length - i; j++)
                if (array[j] < array[j - 1]) {
                    swap(array, j, j - 1);
                    isSorted = false;
                }
            if (isSorted)
                return;
        }
    }

    public  static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > current) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = current;
        }
    }



    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }


    public int[] twoSum(int[] nums, int target) {
        List<Integer> numbers = Arrays.stream(nums).boxed().collect(Collectors.toList());
        for (int  i =0 ; i <  nums.length ; i++) {
            int  remainder = target - nums[i];
            for (int j = i+1; j <nums.length; j++) {
                if (remainder == nums[j]) {
                    return new int[] { i, j };
                }
            }
        }
        return null;
    }

    private static String getBinarayNumber(int value) {
        Stack<Integer> binaryNumber = new Stack<>();
        while (value >1) {
            binaryNumber.push(value % 2);
            value = value / 2;
        }
        binaryNumber.push(value);
        StringBuffer bufferNumber = new StringBuffer();
        while (!binaryNumber.empty()) {
            bufferNumber.append(binaryNumber.pop());
        }
        return binaryNumber.toString();
    }

    static int makeAnagram(String str1, String str2) {
        int CHARS = 26;
        int arr[] = new int[CHARS];
        for (int i = 0; i < str1.length(); i++) {
            arr[str1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < str2.length(); i++) {
            arr[str2.charAt(i) - 'a']--;
        }

        int ans = 0;
        for (int i = 0; i < CHARS; i++) {
            ans += Math.abs(arr[i]);
        }
        return ans;
    }




}
