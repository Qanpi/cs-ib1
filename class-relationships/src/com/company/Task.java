package com.company;

public class Task {
    String name;
    Worker worker;

    public Task(String name) {
        this.name = name;
    }

    public void delegate(Worker w) {
        worker = w;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                '}';
    }
}
