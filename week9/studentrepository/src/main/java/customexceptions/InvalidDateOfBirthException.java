package main.java.customexceptions;

public class InvalidDateOfBirthException extends RuntimeException {
    public InvalidDateOfBirthException(String message) {
        super(message);
    }
}
