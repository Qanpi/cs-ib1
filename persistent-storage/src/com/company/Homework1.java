package com.company;

import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Homework1 {
    final static int MAX_N = 10;
    int numbers[];

    Storage storage;
    String fname;

    Homework1(Storage storage, String fname) {
        this.storage = storage;
        this.fname = fname;

        numbers = new int[MAX_N];
        genNumbers();
    }

    private int[] genNumbers() {
        for(int i=0; i<MAX_N; i++) {
            //numbers[i] = (int)(Math.random()*MAX_N);
            numbers[i] = i;
        }
        return numbers;
    }

    public void store() {
        switch(storage) {
            case Text -> writeAsText();
            case Serialization -> writeSerialized();
            case RandomAccess -> writeRandomAccess();
        }
    }

    public boolean verify() {
        int input[] = new int[MAX_N];
        switch(storage) {
            case Text -> input = readAsText();
            case Serialization -> input = readSerialized();
            case RandomAccess -> input = readRandomAccess(3);
        }
        System.out.println(Arrays.toString(input));
        System.out.println(Arrays.toString(numbers));

        for (int i=0; i<MAX_N; i++) {
            if (input[i] != numbers[i]) return false;
        }
        return true;
    }

    private void writeAsText() {
        File location = new File(fname);

        if (location.exists()) {
            System.out.println("File exists already.");
            return;
        }

        try(PrintWriter out = new PrintWriter(location)) {
            for (int i=0; i<MAX_N; i++) {
                out.print(numbers[i] + " ");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private int[] readAsText() {
        int input[] = new int[MAX_N];
        try (Scanner in = new Scanner(new File(fname))) {
            for (int i=0; i<MAX_N; i++) {
                input[i] = in.nextInt();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return input;
    }

    private void writeSerialized() {
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fname))) {
            out.writeObject(numbers);
        } catch (IOException e) {
            System.err.println("Error while trying to serialize data.");
            e.printStackTrace();
        }
    }

    private int[] readSerialized() {
        int[] input = null; //no space alloc needed
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(fname))) {
            input = (int[]) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error while trying to read serialized data");
            e.printStackTrace();
        }
        return input;
    }

    private void writeRandomAccess() {
        try(RandomAccessFile out = new RandomAccessFile(fname, "rw")) {
            for (int i=0; i<MAX_N; i++) {
                out.writeInt(numbers[i]);
            }
        } catch (IOException e) {
            System.err.println("Error while trying to write to random access file");
            e.printStackTrace();
        }
    }

    private int[] readRandomAccess(int step) {
        int i = 0;
        int len = (int) Math.ceil(MAX_N/(double)step);
        int[] input = new int[len];
        try (RandomAccessFile in = new RandomAccessFile(fname, "r")) {
            while (i < MAX_N) {
                in.seek((long) i * Integer.BYTES);
                input[i/step] = in.readInt();
                i += step;
            }
        } catch (IOException e) {
            System.err.println("Error while trying to read from a random access file.");
            e.printStackTrace();
        }
        return input;
    }
}

