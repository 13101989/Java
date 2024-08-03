package main.java.shapes;

import main.java.Coordinate;
import main.java.Shapable;

public class Circle implements Shapable {
    private final Coordinate center;
    private final double radius;

    public Circle(Coordinate center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

}
