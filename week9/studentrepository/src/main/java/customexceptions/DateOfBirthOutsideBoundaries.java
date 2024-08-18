package main.java.customexceptions;

public class DateOfBirthOutsideBoundaries extends Exception {
    public DateOfBirthOutsideBoundaries(String message) {
        super(message);
    }
}
