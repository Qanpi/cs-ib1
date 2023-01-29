package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EmptyStackException;

public class IntStack {
    IntStack(int capacity) {
        arr = new int[capacity];
    }

    void push(int item) {
        if (isFull()) throw new IndexOutOfBoundsException();

        arr[size] = item;
        size++;
    }

    int pop() {
        if (isEmpty()) throw new EmptyStackException();

        size--;
        return arr[size];
    }

    boolean isEmpty() {
        return size == 0;
    }

    boolean isFull() {
        return size == arr.length;
    }

    private int[] arr;
    private int size;
}
