package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        sequentialSearch();
        binarySearch();
        selectionSort();
        bubbleSort();
        insertionSort();
    }

    public static void insertionSort() {
        int[] arr = {7, 11, 9, 2};
        int n = arr.length;

        for (int i=1; i<n; i++) {
            int temp = arr[i];
            int j = i-1;
            while (j>= 0 && temp < arr[j]) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort() {
        int[] arr = {12, 10, 7, 9, 11, 2};
        int n = arr.length;
        int cap = n;
        boolean changed = true;

        while (changed) {
            changed = false;
            for (int i=1; i<cap; i++) {
                if(arr[i-1] > arr[i]) {
                    changed = true;
                    int temp = arr[i-1];
                    arr[i-1] = arr[i];
                    arr[i] = temp;
                }
            }
            cap--;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void selectionSort() {
        int[] arr = {7, 9, 11, 2};
        int n = arr.length;
        for (int i=0; i<n; i++) {
            int smallest = i;
            for (int j=i+1; j<n; j++) {
                smallest = arr[j] < arr[smallest] ? j : smallest;
            }
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void binarySearch() {
        int[] arr = {1, 2, 3, 4};
        int n = arr.length;
        int key = 3;
        int k = 0;
        for (int step=n/2; step>= 1; step /= 2) {
            while (k+step < n && arr[k + step] <= key) k += step;
        }
        if (arr[k] == key) System.out.println(arr[k]);
    }

    public static void sequentialSearch() {
        int arr[] = {1, 2, 5, 6, 3, 4};
        int key = 3;
        int i;
        for (i=0; i<arr.length; i++) {
                if (arr[i] == key) break;
        }
        System.out.println(arr[i]);
    }
}
