package com.company;
import ibcsutils.Book;

public class Main {

    public static void main(String[] args) {
        User[] users = new User[2];
        users[0] = new User("Doe", "Jane",  "MIA");
        users[1] = new User(
                "Gilmore",
                "Mary",
                  "Downing Street");

        for(User u: users) System.out.println(u);
    }

    public static void hw2() {
        Book[] books = new Book[2];
        books[0] = new Book("The Subtle Art of Not Giving a Fuck", new String[]{"Mark Mason"}, 2016);
        books[1] = new Book("Da Vinci Code", new String[]{"Robert Langdon"}, 2009);
        for (Book b: books) System.out.println(b);
    }
}

