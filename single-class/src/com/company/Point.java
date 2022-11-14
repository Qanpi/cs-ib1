package com.company;

public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public boolean isOnXAxis() {
        return y == 0;
    }

    public boolean sameCoordinates(Point p1) {
        return (this.x == p1.x && this.y == p1.y);
    }

    public double distance(Point p1) {
        double dx = this.x - p1.x;
        double dy = this.y - p1.y;

        return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
    }

    public boolean isInUnitCircle() {
        Point origin = new Point(0, 0);
        return distance(origin) <= 1;
    }

    public Point midpoint(Point p1) {
        //could've just found the distance between the x and y points respectively
        double dx = new Point(x, 0).distance(new Point (p1.x, 0));
        double dy = new Point(0, y).distance(new Point (0, p1.y));

        return new Point(dx/2, dy/2);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
