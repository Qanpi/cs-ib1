package com.company;

public class User {
    private static int nextId = 0;
    private String lastName;
    public String firstName;
    int userId;
    public String address;

    public int getUserId() {
        return userId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public User(String lastName, String firstName, String address) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.userId = nextId++;
        this.address = address;
    }

    public String toString() {
        return lastName + ", " + firstName + " (" + userId + "), " + address;
    }
}
