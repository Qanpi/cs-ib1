package com.company;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sorter<T> extends Application {
    FileWriter fWriter;
    T[] elements;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Graph comparison of sorting algorithms");

        StackPane root = new StackPane();
        stage.setScene(new Scene(root, 1000, 700));
        stage.show();
    }

    enum Sort {
        Insertion,
        Bubble,
        Selection
    }

    Sorter (T[] elements)  {
        this.elements = elements;
    }

    public void run() {
        startWriter();

        for(int i=2; i<=elements.length; i++) {
            T[] a = Arrays.copyOfRange(elements, 0, i);
            shuffle(a);

            //cloning is "deep" as long as primitives/immutables are used
            timeSort(Sort.Selection, a.clone()); //filler because for some reason the first sort is always slowest, no matter the algorithm
            long insertion = timeSort(Sort.Insertion, a.clone());
            long bubble = timeSort(Sort.Bubble, a.clone());
            long selection = timeSort(Sort.Selection, a.clone());

            write(insertion, bubble, selection);
        }

        closeWriter();
    }

    public void startWriter() {
        try {
            File f = new File("output.txt");
            fWriter = new FileWriter(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeWriter() {
        try {
            fWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void write(long... values) {
        StringBuilder line = new StringBuilder();
        int i;
        for (i=0; i < values.length-1; i++) {
            line.append(values[i]).append("\t");
        }
        line.append(values[i]).append("\n");
        try {
            fWriter.write(line.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private long timeSort(Sort s, T[] data) {
        long start = System.nanoTime();
        switch(s) {
            case Insertion -> insertionSort(data);
            case Bubble -> bubbleSort(data);
            case Selection -> selectionSort(data);
        }
        long end = System.nanoTime();
        return end - start;
    }

    private void shuffle(T[] data) {
        List<T> l = Arrays.asList(data);
        Collections.shuffle(l);
        l.toArray(data);

        //System.out.printf("Shuffled array: %s", data);
        //System.out.println();
    }

    private T[] insertionSort(T[] data) {
        for (int i=1; i<data.length; i++) {
            T val = data[i];
            int j = i-1;
            while(j>= 0 && compare(data[j], val)) {
                data[j+1] = data[j];
                j--;
            }
            data[j+1] = val;
        }

        //System.out.printf("Completed insertion sort: %s", data);
        //System.out.println();
        return data;
    }

    private T[] bubbleSort(T[] data){
        boolean changed = true;

        while(changed){
            changed = false; // smart use of booleans
            for (int i=1; i < data.length; i++) {
                if (compare(data[i-1], data[i])) {
                    swap(data, i-1, i);
                    changed = true;
                }
            }
        }

        //System.out.printf("Completed bubble sort: %s", data);
        //System.out.println();
        return data;
    }

    private T[] selectionSort(T[] data) {
        for (int i=0; i<data.length-1; i++) {
            int indSmallest = i;
            //finding index first to avoid unnecessary swapping
            for (int j=i+1; j<data.length; j++) {
                if (compare(data[indSmallest], data[j])) {
                    indSmallest = j;
                }
            }
            swap(data, i, indSmallest);
        }

        //System.out.printf("Completed selection sort: %s", data);
        //System.out.println();
        return data;
    }

    private boolean compare(Object a,Object b) {
        if(a instanceof String && b instanceof String)
            return ((String) a).compareToIgnoreCase((String) b) > 0;

        else if (a instanceof Integer && b instanceof Integer)
            return (int)a > (int)b;

        System.err.println("Unknown comparison for type " + a.getClass().getName());
        return false;
    }

    private void swap(T[] data, int i,int j) {
        T temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
