package com.company;

public class Course {
    private String name;
    private String topic;
    private String nameOfTeacher;
    private int numberOfParticipants;

    public Course(String name, String topic, String nameOfTeacher, int numberOfParticipants) {
        this.name = name;
        this.topic = topic;
        this.nameOfTeacher = nameOfTeacher;
        this.numberOfParticipants = numberOfParticipants;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getNameOfTeacher() {
        return nameOfTeacher;
    }

    public void setNameOfTeacher(String nameOfTeacher) {
        this.nameOfTeacher = nameOfTeacher;
    }

    public int getNumberOfParticipants() {
        return numberOfParticipants;
    }

    public void setNumberOfParticipants(int numberOfParticipants) {
        if (numberOfParticipants < 0) {
            System.err.println("Cannot have a negative number of participants.");
            return;
        }
        this.numberOfParticipants = numberOfParticipants;
    }

    public boolean hasParticipants() {
        return numberOfParticipants != 0;
    }
}
