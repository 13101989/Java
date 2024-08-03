package main.java.shapes;

import main.java.Coordinate;
import main.java.Shapable;

public class Triangle implements Shapable {
    private final Coordinate vertex1, vertex2, vertex3;

    public Triangle(Coordinate vertex1, Coordinate vertex2, Coordinate vertex3) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.vertex3 = vertex3;
    }

    public double getArea() {
        double x1 = vertex1.getX();
        double y1 = vertex1.getY();
        double x2 = vertex2.getX();
        double y2 = vertex2.getY();
        double x3 = vertex3.getX();
        double y3 = vertex3.getY();
        return Math.abs((x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2);
    }

    public double getPerimeter() {
        double x1 = vertex1.getX();
        double y1 = vertex1.getY();
        double x2 = vertex2.getX();
        double y2 = vertex2.getY();
        double x3 = vertex3.getX();
        double y3 = vertex3.getY();
        double side1 = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        double side2 = Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2));
        double side3 = Math.sqrt(Math.pow(x1 - x3, 2) + Math.pow(y1 - y3, 2));
        return side1 + side2 + side3;
    }


}
