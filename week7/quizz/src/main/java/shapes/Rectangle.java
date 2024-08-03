package main.java.shapes;

import lombok.AllArgsConstructor;
import lombok.Data;
import main.java.Coordinate;
import main.java.Shapable;


@Data
@AllArgsConstructor
public class Rectangle implements Shapable {
    private final Coordinate topLeft, bottomRight;

    public double getArea() {
        double width = Math.abs(topLeft.getX() - bottomRight.getX());
        double height = Math.abs(topLeft.getY() - bottomRight.getY());
        return width * height;
    }

    public double getPerimeter() {
        double width = Math.abs(topLeft.getX() - bottomRight.getX());
        double height = Math.abs(topLeft.getY() - bottomRight.getY());
        return 2 * (width + height);
    }
}
