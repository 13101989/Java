package main.java.customexceptions;

public class InvalidGenderException extends Exception {
    public InvalidGenderException(String message) {
        super(message);
    }
}
