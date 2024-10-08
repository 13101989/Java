package main.java;

import java.io.IOException;

public class Main9 {
    public static void main(String[] args) {
        String sourceCsvPath = "/Users/valentindamache/Desktop/Java/assignments/Java/week10/streamsandlambda/src/main/resources/persons.csv";
        String destinationFilePath = "/Users/valentindamache/Desktop/Java/assignments/Java/week10/streamsandlambda/src/main/resources/personsSorted.txt";

        PersonHandler personsContainer = new PersonHandler();
        try {
            personsContainer.findAndReturnPersonsBornInSpecificMonth(sourceCsvPath, 2, destinationFilePath);
        } catch (IOException e) {
            System.out.println("Exception caught: " + e);
        }
    }
}
