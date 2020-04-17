package com.algorithm.domain;


/**
 * Created by mravindran on 01/04/20.
 */
public class QueueWithTwoStacks {

    private java.util.Stack<Integer> stack1 = new java.util.Stack<>();
    private java.util.Stack<Integer> stack2 = new java.util.Stack<>();

    public void enqueue(int value) {
        stack1.push(value);
    }

    // O(n)
    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException();

        moveStack1ToStack2();

        return stack2.pop();
    }

    private void moveStack1ToStack2() {
        if (stack2.isEmpty())
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());
    }

    public int peek() {
        if (isEmpty())
            throw new IllegalStateException();

        moveStack1ToStack2();

        return stack2.peek();
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

}
