package com.company;

import ibadts.Stack;
import ibadts.StaticStack;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        homework4();
    }

    public static void homework4() {
        IntStack test = new IntStack(5);
        test.push(3);
        test.push(4);
        test.push(7);
        test.push(9);
        test.push(10);

        System.out.println(test.pop());
        System.out.println(test.pop());
        System.out.println(test.pop());
        System.out.println(test.pop());
        System.out.println(test.pop());
    }

    public static void homework3() {
        Stack<Character> parentheses = new Stack<>();

        Map<Character, Character> rules = new HashMap<>();
        rules.put(')', '(');
        rules.put('}', '{');
        rules.put(']', '[');

        boolean balanced = true;

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            char next = scanner.next(".").charAt(0);

            if (rules.containsValue(next)) {

                parentheses.push(next);

            } else if (rules.containsKey(next)) {

                if (parentheses.isEmpty()) balanced = false; //account for an extra closing bracket
                else if (parentheses.pop() != rules.get(next)) balanced = false;

            } else break;
        }
        if (!parentheses.isEmpty()) balanced = false; //account for an extra opening bracket

        System.out.println(balanced);
    }

    public static void homework2() {
        StaticStack<String> userWords = new StaticStack<>(10);

        Scanner scanner = new Scanner(System.in);
        while (!userWords.isFull()) {
            userWords.push(scanner.next());
        }

        while (!userWords.isEmpty()) {
            System.out.println(userWords.pop());
        }
    }

    public static void example1() {
        int n = 16;
        Stack<Integer> stack = new Stack<>();

        while (n > 0) {
            stack.push(n % 2);
            n = n / 2;
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}
