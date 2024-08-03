package main.java;

import java.util.ArrayList;
import java.util.List;

public class Shape {
    private List<Shapable> shapes = new ArrayList<>();

    public void addShape(Shapable shape) {
        if (shape == null) {
            throw new IllegalArgumentException("Shape cannot be null");
        } else if (shapes.contains(shape)) {
            throw new IllegalArgumentException("Shape already exists");
        }
        shapes.add(shape);
    }

    public double getTotalArea() {
        double totalArea = 0;
        for (Shapable shape : shapes) {
            totalArea += shape.getArea();
        }
        return totalArea;
    }

    public double getTotalPerimeter() {
        double totalPerimeter = 0;
        for (Shapable shape : shapes) {
            totalPerimeter += shape.getPerimeter();
        }
        return totalPerimeter;
    }
}
