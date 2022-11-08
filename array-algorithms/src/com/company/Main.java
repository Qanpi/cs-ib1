package com.company;

import javax.print.attribute.standard.PresentationDirection;
import java.lang.reflect.Array;
import java.util.Arrays;
import ibcsutils.*;
import javafx.application.Application;


public class Main {

    public static void main(String[] args) {
        int k = 10000;
        Integer[] data = new Integer[k];
        for (int i=0; i<k; i++) {
            data[i] = i;
        }

        Sorter<Integer> s = new Sorter<>(data);
        s.run();
        //Application.launch(GUI.class);
    }

    public static int[] insertionSort(int data[]) { //hw 5
          for (int i=1; i<data.length; i++) {
              int val = data[i];
              int j = i-1;
              while(j>= 0 && data[j] > val) {
                  data[j+1] = data[j];
                  j--;
              }
              data[j+1] = val;
          }

          return data;
    }

    public static void hw4() {
        String addr = "http://www-personal.umich.edu/~jlawler/wordlist";

        String[] words = ReadViaURL.readWords(addr, true, true, true);
        boolean found = sequentialSearch(words, "test");
        System.out.println(found);

        found = binarySearch(words, "test");
        System.out.println(found);
    }

    static int[] bubbleSort(int data[]){
        //how could you utilize the fact that the last element is always last after first pass

        boolean changed = true;

        while(changed){
            changed = false; // smart use of booleans
            for (int i=1; i< data.length; i++) {
                if (data[i-1] > data[i]) {
                    swap(data, i-1, i);
                    changed = true;
                }
            }
        }
        return data;
    }

    static void swap(int[] arr,int i,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int[] selectionSort(int data[]) {
        for (int i=0; i<data.length-1; i++) {
            int indSmallest = i;
            //finding index first to avoid unnecessary swapping
            for (int j=i+1; j<data.length; j++) {
                if (data[j] < data[indSmallest]) {
                    indSmallest = j;
                }
            }
            int temp = data[i];
            data[i] = data[indSmallest];
            data[indSmallest] = temp;
        }
        return data;
    }


    static void hw2() {
        String[] students = {"Alissa", "Ben", "Charlie", "Dianna"};
        String[] grades = {"B", "D", "B", "A"};
        String key = "Charlie";
        for (int i=0; i<students.length; i++) {
            if (students[i].equals(key)) {
                System.out.println(grades[i]);
            }
        }
    }

    static void binarySearchExample() {
        int[] data = {-2, 9, 11, 12, 13, 14, 15, 22, 142};
        int key = 15;

        int lo = 0, hi = data.length - 1;

        boolean found = false;
        while (!found && lo <= hi) {
            int mid = (lo + hi) / 2;
            int val = data[mid];
            System.out.println(val);
            if (val == key) {
                found = true;
            } else if (val > key) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        System.out.println(found);
    }

    static boolean binarySearch(String[] words, String key) {
        int k=0;
        for(int step=words.length/2; step>=1; step/=2) {
            while(k+step < words.length && words[k+step].compareTo(key) <= 0) k+=step;
        }
        if (words[k].equals(key)) System.out.println(words[k]);
        return true;
    }


    static void binarySearch(int data[], int key) {
        int k = 0;
        for (int step = data.length/2; step >= 1; step /= 2) {
            while (k + step < data.length && data[k+step] <= key) k += step;
        }
        if (data[k] == key) {
            System.out.println(data[k]);
        }
    }

    static boolean sequentialSearch(String[] words, String key) {
        for(String w : words) if (w.equals(key)) return true;
        return false;
    }

    static void sequentialSearch(int [] numbers, int key) {
        int i = 0;
        boolean found = false;
        while (!found && i < numbers.length) {
            if (numbers[i] == key) {
                found = true;
           }
            i++;
        }
        System.out.println(found);
    }


    static void sequentialObjectSearch() {
        Reservation[] reservations = new Reservation[3];
        reservations[0] = new Reservation("John", 15);
        reservations[1] = new Reservation("Jane", 2);
        reservations[2] = new Reservation("Wendy", 15);
        String key = "Jane";
//        for (int i=0; i<reservations.length; i++) {
//            if (reservations[i].name.equals(key)) {
//                System.out.println(reservations[i].room);
//                break;
//            }
//        }

        for (Reservation r : reservations) {
            if (r.name.equals(key)) {
                System.out.println(r.room);
                break;
            }
        }
    }

}

class Reservation {
    Reservation (String name, int room) {
        this.name = name;
        this.room = room;
    }

    String name;
    int room;
}
