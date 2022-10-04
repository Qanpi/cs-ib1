package com.company;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
//        int A[] = {1, 2, 3, 4, 5};
//        int B[] = {6, 6, 7, 8, 9};
//        boolean test = hw2(A, B);
//        System.out.println(test);
//        hw4();
//        boolean test = uniques(new int[] {1, 2, 3, 3});
//        System.out.println(test);
        symdiff(new int[] {4, 4, 6, 11, -2, 3}, new int[] {5, 11, 11, -3, 3, 5});
    }

    static void example1() {
        int rows = 9;
        String stars = "*";
        String dashes = "-";
        //doesn't require being solved with a nested for-loop
        for (int i=1; i<=rows; i++) {
            if(i%2 == 0) {
                System.out.println(dashes);
            } else {
                System.out.println(stars);
            }
            dashes += "-";
            stars += "*";
        }
    }

    static void example2() {
        int[] numbers = {7, -5, 11, 6};
        // we are guaranteed to have the first element be the smallest one
        // What is the computational complexity? 3+2+1 for this case
        // Selection sort
        for (int i =0; i<numbers.length; i++) {
            for (int j=i + 1; j<numbers.length; j++) {
                if (numbers[j] < numbers[i]) {
                    int t = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = t;
                }
            }
        }

        System.out.println(Arrays.toString(numbers));
    }

    static void example3() {
        String[] flights = {"AY664", "BA047", "AF110", "LH554", "AF003", "BA116", "AY101"};
        String[] airlines = {"AY", "UA", "LH"};
        System.out.print("flights:");
        for (String f : flights) {
            System.out.print(" " + f);
        }
        System.out.println();

        System.out.print("airlines:");
        //Generally shouldn't copy/paste in an actual project
        for (String a : airlines) {
            System.out.print(" " + a);
        }
        System.out.println();

        for (String a : airlines) {
            System.out.print(a + ":");
            for (String f : flights) {
                if (f.startsWith(a))
                    System.out.print(" " + f);
            }
            System.out.println();
        }

    }

    static void hw1() {
        for (int i=1; i<=5; i++) {
            for (int j=1; j<=5; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        System.out.println();

        for (int i=1; i<=5; i++) {
            for (int j=i; j<=i+4; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    static boolean hw2(int[] A, int[] B) {
        for (int a : A) {
            for (int b : B) {
                if (a == b) {
                    return true;
                }
            }
        }
        return false;
    }

    static void hw3() {
        int[] NUMS = {3, 7, 4, 5};
        for (int k=0; k< NUMS.length; k++) {
            for (int l=0; l< NUMS.length; l++) {
                if (k != l) {
                    System.out.print(10 * NUMS[k] + NUMS[l] + " ");
                }
            }
            System.out.println();
        }
    }

    static void hw4() {
        String stars = "******";
        for (int i=6; i>0; i--) {
            System.out.println(stars.substring(0, i));
        }

        String dashes = "-----";
        for (int i=1; i<=6; i++) {
            System.out.print(stars.substring(0, i));
            System.out.println(dashes.substring(i-1));
        }
    }

    static boolean uniques(int[] numbers) {
        for (int i=0; i<numbers.length; i++) {
            for (int j=0; j<numbers.length; j++) {
                if (i != j && numbers[i] == numbers[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    static void diff(int[] a, int[]b ) {
        for (int i=0; i<a.length; i++) {
            boolean unique = true;
            for (int j=0; j<b.length; j++) {
                if (a[i] == b[j]) {
                    unique = false;
                }
            }
            if (unique) System.out.print(" " + a[i]);
        }
    }

    static void symdiff(int[] a, int[] b) {
        System.out.print("a:");
        for (int e : a) {
            System.out.print(" " + e);
        }
        System.out.println();

        System.out.print("b:");
        for (int e : b) {
            System.out.print(" " + e);
        }
        System.out.println();

        System.out.print("sym diff:");
        diff(a, b);
        diff(b, a);
    }
}
