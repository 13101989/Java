package main.java.shapes;

import lombok.AllArgsConstructor;
import lombok.Data;
import main.java.Coordinate;
import main.java.Shapable;

@Data
@AllArgsConstructor
public class Circle implements Shapable {
    private final Coordinate center;
    private final double radius;

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

}
