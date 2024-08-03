package test.java;

import main.java.*;
import main.java.shapes.Circle;
import main.java.shapes.Rectangle;
import main.java.shapes.Square;
import main.java.shapes.Triangle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ShapeTest {
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
    void canInstantiate() {
        assertNotNull(square);
        assertNotNull(rectangle);
        assertNotNull(circle);
        assertNotNull(triangle);
    }

    @Test
    void getTotalAreaForASquare() {
        Shape shapeManager = new Shape();
        Shapable[] shapes = new Shapable[]{square};

        double expected = square.getArea();
        double actual = shapeManager.getTotalArea(shapes);

        assertEquals(expected, actual);
    }

    @Test
    void getTotalAreaForARectangle() {
        Shape shapeManager = new Shape();
        Shapable[] shapes = new Shapable[]{rectangle};

        double expected = rectangle.getArea();
        double actual = shapeManager.getTotalArea(shapes);

        assertEquals(expected, actual);
    }

    @Test
    void getTotalAreaForACircle() {
        Shape shapeManager = new Shape();
        Shapable[] shapes = new Shapable[]{circle};

        double expected = circle.getArea();
        double actual = shapeManager.getTotalArea(shapes);

        assertEquals(expected, actual);
    }

    @Test
    void getTotalAreaForATriangle() {
        Shape shapeManager = new Shape();
        Shapable[] shapes = new Shapable[]{triangle};

        double expected = triangle.getArea();
        double actual = shapeManager.getTotalArea(shapes);

        assertEquals(expected, actual);
    }

    @Test
    void getTotalAreaForASquareTriangleRectangleAndCircle() {
        Shape shapeManager = new Shape();
        Shapable[] shapes = new Shapable[]{square,rectangle,circle,triangle};

        double expected = triangle.getArea() + circle.getArea() + rectangle.getArea() + square.getArea();
        double actual = shapeManager.getTotalArea(shapes);

        assertEquals(expected, actual);
    }


    @Test
    void getTotalPerimeter() {
    }
}