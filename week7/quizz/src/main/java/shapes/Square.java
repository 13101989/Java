package main.java.shapes;

import lombok.AllArgsConstructor;
import lombok.Data;
import main.java.Coordinate;
import main.java.Shapable;


@Data
@AllArgsConstructor
public class Square implements Shapable {
    private final Coordinate topLeft, bottomRight;

    public double getArea() {
        double width = Math.abs(topLeft.getX() - bottomRight.getX());
        return width * width;
    }

    public double getPerimeter() {
        double width = Math.abs(topLeft.getX() - bottomRight.getX());
        return 4 * width;
    }
}
