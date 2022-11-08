package com.company;

public class Newspaper {
    private String name;
    private int year;
    private int month;
    private int dayOfMonth;
    private boolean isFinnish;

    public Newspaper(String name, int year, int month, int dayOfMonth, boolean isFinnish) {
        this.name = name;
        this.year = year;
        this.month = month;
        this.dayOfMonth = dayOfMonth;
        this.isFinnish = isFinnish;
    }

    public void setDate(int year, int month, int dayOfMonth) {
        this.year = year;
        this.month = month;
        this.dayOfMonth = dayOfMonth;
    }


    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public boolean isFinnish() {
        return isFinnish;
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    @Override
    public String toString() {
        return "Newspaper{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", month=" + month +
                ", dayOfMonth=" + dayOfMonth +
                ", isFinnish=" + isFinnish +
                '}';
    }
}
