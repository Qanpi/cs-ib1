package com.company;

public class Worker {
    String name;

    public Worker(String name) {
        this.name = name;
    }
}

class Employee extends Worker {
    int employeeId;

    public Employee(String name, int employeeId) {
        super(name);
        this.employeeId = employeeId;
    }

}

class HiredContractor extends Worker {

    public HiredContractor(String name) {
        super(name);
    }
}
