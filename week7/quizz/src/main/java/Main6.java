package main.java;

import main.java.shapes.Circle;
import main.java.shapes.Rectangle;
import main.java.shapes.Square;
import main.java.shapes.Triangle;

import java.util.Arrays;

/**
 * You need to design an application that allows the possibility to calculate the surface (area) and perimeter for multiple types of shape:
 * rectangle, square, circle and triangle.
 * <p>
 * For each shape you must memorize coordinate points for it's vertices.
 * <p>
 * A square is made of a top left vertex and a bottom left vertex, with the restriction that the difference in x and y coordinates
 * between the 2 points is the same.
 * A rectangle is the same as a square, without the restriction. A triangle has 3 vertices.
 * A circle has 1 vertex as center and a radius.
 * <p>
 * The tool should allow the possibility to add multiple shapes and calculate the total sum for perimeter and for the surface from all the
 * shapes in the system.
 * The application should make sure that 2 similar shapes couldn’t be added to the drawing tool. In case 2 similar shapes are added,
 * an appropriate message should be printed to console. 2 shapes are considered similar if they have the same surface and perimeter and
 * are of the same type.
 * Since you want to be sure that you provide a high quality implementation, unit tests are needed to prove the main functionalities
 * described above work correctly (add all types of shapes, add duplicates, add single shape and pairs of shapes).
 * To deliver the work, just make a zip file with the src folder (main and test) and attach it to the answer.
 */

public class Main6 {
    public static void main(String[] args) {
        Coordinate topLeftSquare = new Coordinate(2, 2);
        Coordinate bottomRightSquare = new Coordinate(0, 0);
        Square square = new Square(topLeftSquare, bottomRightSquare);
        System.out.println("Square area: " + square.getArea());
        System.out.println("Square perimeter: " + square.getPerimeter());

        System.out.println();
        Coordinate topLeftRectangle = new Coordinate(1, 3);
        Coordinate bottomRightRectangle = new Coordinate(4, 1);
        Rectangle rectangle = new Rectangle(topLeftRectangle, bottomRightRectangle);
        System.out.println("Rectangle area: " + rectangle.getArea());
        System.out.println("Rectangle perimeter: " + rectangle.getPerimeter());

        System.out.println();
        Coordinate centerCircle = new Coordinate(0, 0);
        Circle circle = new Circle(centerCircle, 5);
        System.out.println("Circle area: " + circle.getArea());
        System.out.println("Circle perimeter: " + circle.getPerimeter());

        System.out.println();
        Coordinate vertex1 = new Coordinate(0, 0);
        Coordinate vertex2 = new Coordinate(0, 1);
        Coordinate vertex3 = new Coordinate(1, 0);
        Triangle triangle = new Triangle(vertex1, vertex2, vertex3);
        System.out.println("Triangle area: " + triangle.getArea());
        System.out.println("Triangle perimeter: " + triangle.getPerimeter());

        System.out.println();
        ShapeManager shapeManager = new ShapeManager();
        Shape[] shapes = new Shape[]{square, rectangle, circle};
        System.out.println("Total area: " + shapeManager.getTotalArea(shapes));
        System.out.println("Total perimeter: " + shapeManager.getTotalPerimeter(shapes));
    }
}
