package com.algorithm.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by mravindran on 28/03/20.
 */
public class Array {

    private int[] numbers;
    private int count;

    public Array(int length) {
        numbers = new int[length];
    }

    public void insert(int value) {
        recreateArrayIfExceededLimit();
        numbers[count++] = value;
    }

    public void insertAt(int index, int value) {
        if (index < 0 || index > count) {
            throw new  IllegalArgumentException("Index out of bond");
        }

        recreateArrayIfExceededLimit();

            for (int i = count - 1; i >= index; i--)
                numbers[i + 1] = numbers[i];

            numbers[index] = value;
            count++;
        }

    public void reverse()  {
        int[] newNumbers = new int[count];
        for (int i =count -1 ; i >= 0; i--) {
            newNumbers[(count -1) - i]  = numbers[i];
        }
        numbers = newNumbers;
    }

    public int max() {
        int maxItem = 0;
        for (int i =0 ; i < count; i++) {
            if (numbers[i] > maxItem) {
                maxItem = numbers[i];
            }
        }
        return maxItem;
    }

    public Array intersect(Array  other) {
        Array newNumbers =   new Array(count);
        for (int number : numbers) {
            if  (other.indexOf(number) >= 0) {
                 newNumbers.insert(number);
            }
        }
       return newNumbers;
    }



    private void recreateArrayIfExceededLimit() {
        if (numbers.length == count) {
            int[] newNumbers = new int[count * 2];

            for (int i = 0; i < count; i++)
                newNumbers[i] = numbers[i];

            numbers = newNumbers;
        }
    }

    public void removeAt(int index) {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException();
        }

        for (int i = index; i < count; i++) {
            if (i+1 == count) {
                numbers[i] = 0;
            } else {
                numbers[i] = numbers[i + 1];
            }
        }

        count--;
    }

    public int indexOf(int  value) {
        for (int i =0; i < count; i++) {
            if (value == numbers[i]) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return "Array{" +
                "numbers=" + Arrays.toString(numbers) +
                ", count=" + count +
                ", size="+ numbers.length +
                '}';
    }
}
