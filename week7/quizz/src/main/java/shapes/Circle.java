package main.java.shapes;

import main.java.Shape;

public class Circle implements Shape {
    private final double x;
    private final double radius;

    public Circle(double x, double radius) {
        this.x = x;
        this.radius = radius;
    }

    public void getArea() {

    }

    public void getPerimeter() {

    }

    public double getX() {
        return x;
    }

    public double getRadius() {
        return radius;
    }
}
