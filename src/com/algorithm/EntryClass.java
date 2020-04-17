package com.algorithm;

import com.algorithm.domain.*;
import com.algorithm.domain.LinkedList;
import com.algorithm.domain.PriorityQueue;
import com.algorithm.domain.Stack;

import java.util.*;
import java.util.HashMap;

/**
 * Created by mravindran on 28/03/20.
 */
public class EntryClass {

    public static void main(String args[]) {
        Array array = new Array(3);
        array.insert(10);
        array.insert(20);
        array.insert(30);
        array.insert(40);
        System.out.println(array.toString());
        System.out.println(array.max());
        array.reverse();
        System.out.println(array.toString());
        System.out.println(array.max());
        Array newArray = new Array(2);
        newArray.insert(30);
        newArray.insert(50);
        Array intersectArray = array.intersect(newArray);
        System.out.println(intersectArray.toString());

        LinkedList list  = new LinkedList();
        list.addFirst(14);
        list.addFirst(12);
        list.addLast(15);
        list.addLast(16);
        list.addLast(17);

        list.deleteFirst();
        list.deleteLast();
        int index = list.indexOf(14);
        int index1 = list.indexOf(15);
        boolean contains = list.contains(17);
        boolean contains1 = list.contains(15);
        int[] listToArray = list.toArray();
        System.out.println(Arrays.toString(listToArray));
        list.reverse();

        System.out.println(Arrays.toString(list.toArray()));

        LinkedList list2  = new LinkedList();
        list2.addFirst(10);
        list2.addLast(20);
        list2.addLast(30);
        list2.addLast(40);
        list2.addLast(50);
        list2.addLast(60);

        int value = list2.getKthNodeValue(4);

        StringReverser stringReverser = new StringReverser();
        String reverser = stringReverser.reverse("abcd");

        Expression expression = new Expression();
        System.out.println(expression.isBalanced("(1 + 2)"));
        System.out.println(expression.isBalanced("(1 + 2"));
        System.out.println(expression.isBalanced("((1 + 2)"));
        System.out.println(expression.isBalanced(")1 + 2("));
        System.out.println(expression.isBalanced("(1 +  2 ]"));
        Stack stack = new Stack();
        stack.push(12);
        stack.push(13);
        stack.push(14);
        stack.push(15);

        System.out.println(stack.toString().trim());

        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
        MinStack minStack =  new MinStack();
        minStack.push(12);
        minStack.push(11);
        minStack.push(13);

        minStack.min();

        TwoStacks twoStacks =   new TwoStacks(4);
        twoStacks.push1(1);
        twoStacks.push1(2);
        twoStacks.push1(3);
        twoStacks.push1(4);


        System.out.println(twoStacks.pop1());

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);

        System.out.println("Peek"+queue.peek());

        System.out.println(queue);

        Stack  reverseStack = new Stack();

        while (!queue.isEmpty()) {
            reverseStack.push(queue.remove());
        }

        Queue<Integer> reverseQueue = new ArrayDeque<>();
        while (!reverseStack.isEmpty()) {
            queue.add(reverseStack.pop());
        }
        System.out.println(queue);




        //reverse a queue

        ArrayQueue arrayQueue = new ArrayQueue(5);
        arrayQueue.enqueue(1);
        arrayQueue.enqueue(2);
        arrayQueue.enqueue(3);
        arrayQueue.dequeue();
        arrayQueue.dequeue();
        arrayQueue.enqueue(4);
        arrayQueue.enqueue(5);
        arrayQueue.enqueue(6);
        arrayQueue.enqueue(7);
        System.out.println(arrayQueue);



        System.out.println(arrayQueue.peek());


        QueueWithTwoStacks  queueWithTwoStacks = new QueueWithTwoStacks();
        queueWithTwoStacks.enqueue(10);
        queueWithTwoStacks.enqueue(20);
        queueWithTwoStacks.enqueue(30);

        System.out.println("Dequeue1 " + queueWithTwoStacks.dequeue());
        queueWithTwoStacks.enqueue(40);
        System.out.println("Dequeue2 " + queueWithTwoStacks.dequeue());

        PriorityQueue pq = new PriorityQueue();
        pq.add(5);
        pq.add(6);
        pq.add(1);

        ArrayDeque<Integer> integers = new ArrayDeque<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        QueueReverser.reverse(integers, 2);

        StackWithTwoQueues stackWithTwoQueues = new StackWithTwoQueues();
        stackWithTwoQueues.push(10);
        stackWithTwoQueues.push(20);

        stackWithTwoQueues.peek();

        stackWithTwoQueues.pop();

        int[] numbers = {2, 7, 11, 15};
        HashTableExercises hashTableExercises = new HashTableExercises();
        hashTableExercises.mostFrequent(numbers);

        hashTableExercises.twoSum(numbers, 9);




    }
}
