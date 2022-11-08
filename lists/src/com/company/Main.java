package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        hw6();
    }

    public static void hw6() {
        List<Integer> list = new List<> (new Integer[5]);

        for (int i = 1; !list.isFull() && i < 100; i += 2)
            list.addFirst(i);
        System.out.println(list);

        list.removeLast();
        list.removeLast();
        System.out.println (list);

        // implement these methods
        list.addLast (99);
        list.add (1, -33);
        System.out.println (list);

        // implement methods so that you can uncomment this code
         while (!list.isEmpty ())
           System.out.print (list.removeFirst () + " ");
        System.out.println ("");
    }

    /**
     * Homework #4
     * @param list linked list to flatten
     */
    public static LinkedList<Integer> flatten(LinkedList<LinkedList<Integer>> list) {
        LinkedList<Integer> flattened = new LinkedList<>();
        while (!list.isEmpty()) {
            LinkedList<Integer> l = list.remove();
            while (!l.isEmpty()) {
                int el = l.remove();
                flattened.add(el);
            }
        }
        return flattened;
    }

    public static void hw3() {
        LinkedList<Integer> integers = new LinkedList<>();
        try (Scanner sc = new Scanner(System.in)) {
            while(sc.hasNextInt()) {

                int input = sc.nextInt();
                int location = -1;

                for (int i=0; i<integers.size(); i++) {
                    if (input == integers.get(i)) location = i;
                }

                if(location >= 0) integers.remove(location);
                integers.add(0, input);
            }

            System.out.println(integers);
        }
    }

    public static void hw2() {
        ArrayList<String> typedIn = new ArrayList<>();
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("stage 1: ");
            while(true) {
                String word = sc.next();
                if (word.equals("!")) break;
                typedIn.add(word);
            }

            System.out.println("stage 2: ");
            while(true) {
                String word = sc.next();
                if (word.equals("!")) break;
                for(String saved : typedIn) {
                    if (saved.equals(word)) System.out.println("hit");
                }
            }
        }
    }

    public static void insertUpfront() {
        LinkedList<Integer> list = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int val = sc.nextInt();
            int i = 0;
            while (i < list.size() && list.get(i) > val) i++;
            list.add(i, val); //autoboxing
        }
        sc.close();
        System.out.println(list);
    }

}
