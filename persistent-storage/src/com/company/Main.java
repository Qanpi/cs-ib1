package com.company;

public class Main {

    public static void main(String[] args) {
        Homework1 storage = new Homework1(Storage.RandomAccess, "numbers.bin");
        storage.store();
        System.out.println(storage.verify());
    }


}

enum Storage {
    Text,
    RandomAccess,
    Serialization,
    Database
}
