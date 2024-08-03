package main.java;

public class Shape {
    public static double getTotalArea(Shapable[] shapes) {
        double totalArea = 0;
        for (Shapable shape : shapes) {
            totalArea += shape.getArea();
        }
        return totalArea;
    }

    public static double getTotalPerimeter(Shapable[] shapes) {
        double totalPerimeter = 0;
        for (Shapable shape : shapes) {
            totalPerimeter += shape.getPerimeter();
        }
        return totalPerimeter;
    }
}
