package com.algorithm.domain;

import java.security.NoSuchAlgorithmException;
import java.util.NoSuchElementException;

/**
 * Created by mravindran on 30/03/20.
 */
public class LinkedList {

    private class Node {

        private  int value;

        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node first;

    private Node last;

    private int size;

    //addFirst

    public void addFirst(int value) {
        Node node = new Node(value);

        if (isEmpty())
            first = last = node;
        else {
            node.next = first;
            first = node;
        }

        size++;
    }

    //addLast
    public void addLast(int value) {
        Node node = new Node(value);

        if (isEmpty())
            first = last = node;
        else {
            last.next = node;
            last = node;
        }

        size++;
    }

    private boolean isEmpty() {
        return first == null;
    }

    //deleteFirst
    public void deleteFirst()  {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }else {
            if (first  == last) {
                first = last = null;
            }else {
                Node tempNode = first.next;
                first.next = null;
                first =   tempNode;
            }
        }
       size--;

    }


    //deleteLast
public void deleteLast() {
    if (isEmpty()) {
        throw new NoSuchElementException();
    }else {
        if (first == last) {
            first = last = null;
        }else {
            Node previousNode = findPrevious(last);
            last = previousNode;
            last.next = null;
        }
    }
    size--;
}

    private Node findPrevious(Node node) {
        Node currentNode = first;
        while (currentNode != null) {
            if (currentNode.next == node) return currentNode;
            currentNode = currentNode.next;
        }
        return null;
    }
    //contains
    public boolean contains(int value) {
        return (indexOf(value) > 0);
    }

    //indexOf
    public int indexOf(int value) {
        Node currentNode = first;
        for (int i = 0; i < size; i++) {
            if (currentNode.value == value) {
                return i;
            }else {
                currentNode = currentNode.next;
            }
        }
        return -1;
    }

    //toArray
    public int[] toArray() {
        int[]   array = new int[size];
        int index = 0;
        Node currentNode = first;
        while (currentNode != null) {
            array[index++] = currentNode.value;
            currentNode = currentNode.next;
        }
        return array;
    }

    public void reverse() {
        //[10 -> 20 -> 30] == [30  -> 20 -> 10]
        //        p     c      n
        // c.next  -> p

        if (isEmpty()) {
            return;
        }

        Node firstNode = first;
        Node secondNode = first.next;
        while (secondNode != null) {
            Node next = secondNode.next;
            secondNode.next = firstNode;
            firstNode = secondNode;
            secondNode = next;
        }

        last = first;
        last.next=null;
        first = firstNode;
    }


    public int getKthNodeValue(int k) {
        Node a = first;
        Node b = first;
            for (int i = 1; i < k; i++) {
                b = b.next;
                if   (b  ==  null)  {
                    throw new IllegalArgumentException();
                }
            }
            while (b != last) {
                a = a.next;
                b = b.next;
            }
            return a.value;
        }

    //[10, 20, 30, 40, 50, 60]
    //

    public boolean hasLoop() {
        Node slow = first;
        Node fast = first;
        if (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if(slow == fast) {
            return true;
        }
        return false;
    }

    public static LinkedList createWithLoop() {
        LinkedList list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        // Get a reference to 30
        Node node = list.last;

        list.addLast(40);
        list.addLast(50);

        // Create the loop
        list.last.next = node;

        return list;
    }

    public void printMiddle() {
        if (isEmpty())
            throw new IllegalStateException();

        Node a = first;
        Node b = first;
        while (b != last && b.next != last) {
            b = b.next.next;
            a = a.next;
        }

        if (b == last)
            System.out.println(a.value);
        else
            System.out.println(a.value + ", " + a.next.value);
    }
}
