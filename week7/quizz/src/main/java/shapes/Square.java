package main.java.shapes;

import main.java.Coordinate;
import main.java.Shape;

public class Square implements Shape {
    private final Coordinate topLeft, bottomRight;

    public Square(Coordinate topLeft, Coordinate bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    public double getArea() {
        double width = Math.abs(topLeft.getX() - bottomRight.getX());
        return width * width;
    }

    public double getPerimeter() {
        double width = Math.abs(topLeft.getX() - bottomRight.getX());
        return 4 * width;
    }
}
