package com.company;

import javax.print.attribute.standard.PresentationDirection;

public class Main {

    public static void main(String[] args) {
        hw2();
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


    static void binarySearchShortcut() {
        int[] data = {-5, -2, 0, 15, 22, 37, 44};
        int key = 0;
        for (int step = data.length; step > 0; step /= 2) {
            if (data[step-1] == key) {
                System.out.println("found");
            } else if (data[step-1] > key) {
                continue;
            }
        }
    }

    static void sequentialSearch() {
        int[] numbers = {5, -4, 15, 76, 22};
        int i = 0;
        int key = 15;
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
