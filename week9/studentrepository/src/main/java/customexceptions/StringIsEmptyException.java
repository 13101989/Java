package main.java.customexceptions;

public class StringIsEmptyException extends Exception {
    public StringIsEmptyException(String message) {
        super(message);
    }
}
