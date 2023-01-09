package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int N = 10;
        int[] arr = new int[N];
        int key = (int) (Math.random()*N);
        for (int i=0; i<arr.length; i++)
            arr[i] = (int) (Math.random()*N);

        System.out.println(Arrays.toString(arr) + ", searching for: " + key);
        int i = recursiveSequentialSearch(arr, 0, key);
        System.out.println(i);
    }

    public static int S (int n) {
        if (n == 1) return 1;
        else return S(n-1) + n;
    }

    static int f(int n) {
        int prev=1, curr = 2;
        if (n==0) return prev;
        else {
            for (int i=0; i<n; i++) {
                int next = 2 * curr + prev - 1;
                prev = curr;
                curr = next;
            }

            return curr;
        }
    }

    public static int Factorial(int n) {
        if (n == 2) return 2;
        return Factorial(n-1) * n;
    }

    public static int iterativeFactorial(int n) {
        int fact = 1;
        for (int i=2; i<=n; i++) {
            fact *= i;
        }
        return fact;
    }

    public static int telephoneNumbers(int n) {
        if (n == 1 || n == 0) return 1;
        return telephoneNumbers(n-1) + (n-1)*telephoneNumbers(n-2);
    }

    public static int iterativeTelephoneNumbers(int n) {
        int prev = 1, curr = 1;
        if (n == 0) return 1;
        for (int i=1; i<=n; i++) {
            int next = curr + (i-1) * prev;
            prev = curr;
            curr = next;
        }

        return curr;
    }

    public static int recursiveSequentialSearch(int[] arr, int i, int key) {
        if (i >= arr.length) return -1;
        if (arr[i] == key) return i;
        return recursiveSequentialSearch(arr, i+1, key);
    }
}
