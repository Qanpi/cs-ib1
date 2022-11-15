package com.company;

import java.util.ArrayList;
import java.util.SplittableRandom;

public class Project {
    static int index = 0;
    int id;
    ArrayList<Task> tasks;

    public Project() {
        this.id = index++;
        this.tasks = new ArrayList<>();
    }

    public Project(ArrayList<Task> tasks) {
        this.id = index++;
        this.tasks = tasks;
    }

    public Task addTask(Task t) {
        tasks.add(t);
        return t;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Project #").append(id).append("\n");
        for (int i=0; i<tasks.size(); i++) {
            sb.append(i+1).append("\t");
            sb.append(tasks.get(i).name)
                    .append("\t -> \t delegated to ")
                    .append(tasks.get(i).worker.name)
                    .append("\n");
        }
        return sb.toString();
    }
}
