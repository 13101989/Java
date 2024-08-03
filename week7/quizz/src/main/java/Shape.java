package main.java;

public class Shape {
    public double getTotalArea(Shapable[] shapes) {
        double totalArea = 0;
        for (Shapable shape : shapes) {
            totalArea += shape.getArea();
        }
        return totalArea;
    }

    public double getTotalPerimeter(Shapable[] shapes) {
        double totalPerimeter = 0;
        for (Shapable shape : shapes) {
            totalPerimeter += shape.getPerimeter();
        }
        return totalPerimeter;
    }
}
