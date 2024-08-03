package main.java.shapes;

import main.java.Shape;

public class Triangle implements Shape {
    private final double x;
    private final double y;
    private final double z;

    public Triangle(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getArea() {

    }

    public double getPerimeter() {

    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }
}
