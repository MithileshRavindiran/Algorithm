package com.algorithm.domain;

import java.util.Arrays;

/**
 * Created by mravindran on 01/04/20.
 */
public class ArrayQueue {


    private int[] items =  new int[5];
    private int first;
    private int last;
    private int count;

    public ArrayQueue(int capacity) {
      items = new int[capacity];
    }

    public void enqueue(int value) {

        if (isFull())
            throw new IllegalStateException();
        if (count == items.length) {
            throw new  IllegalArgumentException();
        }

        items[last] = value;
        last  = (last+1) % items.length;
        count++;

    }

    public int  dequeue() {

        if (isEmpty())
            throw new IllegalStateException();
        int item =  items[first];
        items[first] = 0;
        first = (first+1)%items.length;
        count--;
        return item;

    }

    public int peek() {
        if (isEmpty())
            throw new IllegalStateException();
        return items[first];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == items.length;
    }

    @Override
    public String toString() {
        return "ArrayQueue{" +
                "items=" + Arrays.toString(items) +
                ", first=" + first +
                ", last=" + last +
                ", count=" + count +
                '}';
    }
}
