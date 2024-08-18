package main.java.customexceptions;

public class StringIsEmptyException extends RuntimeException {
    public StringIsEmptyException(String message) {
        super(message);
    }
}
