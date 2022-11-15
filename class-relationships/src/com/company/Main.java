package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Project essay = new Project();
        Worker me = new Employee("Aleksei", 42069);
        Worker ghostwriter = new HiredContractor("FreeEssays.com");

        essay.addTask(new Task("Do some research")).delegate(me);
        essay.addTask(new Task("Attempt writing the introduction paragraph.")).delegate(me);
        essay.addTask(new Task("Give up and procrastinate.")).delegate(me);
        essay.addTask(new Task("Write the essay")).delegate(ghostwriter);

        System.out.println(essay);
    }
}
