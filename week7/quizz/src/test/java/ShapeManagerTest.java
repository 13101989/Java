package test.java;

import main.java.*;
import main.java.shapes.Circle;
import main.java.shapes.Rectangle;
import main.java.shapes.Square;
import main.java.shapes.Triangle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShapeManagerTest {
    private Coordinate topLeftSquare;
    private Coordinate bottomRightSquare;
    private Square square;

    private Coordinate topLeftRectangle;
    private Coordinate bottomRightRectangle;
    private Rectangle rectangle;

    private Coordinate centerCircle;
    private Circle circle;

    private Coordinate vertex1;
    private Coordinate vertex2;
    private Coordinate vertex3;
    private Triangle triangle;

    @BeforeEach
    void set_up() {
        topLeftSquare = new Coordinate(2, 2);
        bottomRightSquare = new Coordinate(0, 0);
        square = new Square(topLeftSquare, bottomRightSquare);

        topLeftRectangle = new Coordinate(1, 3);
        bottomRightRectangle = new Coordinate(4, 1);
        rectangle = new Rectangle(topLeftRectangle, bottomRightRectangle);

        centerCircle = new Coordinate(0, 0);
        circle = new Circle(centerCircle, 5);

        vertex1 = new Coordinate(0, 0);
        vertex2 = new Coordinate(0, 1);
        vertex3 = new Coordinate(1, 0);
        triangle = new Triangle(vertex1, vertex2, vertex3);
    }

    @Test
    void getTotalArea() {
        Shape shapeManager = new Shape();
        Shapable[] shapes = new Shapable[]{square};
    }

    @Test
    void getTotalPerimeter() {
    }
}