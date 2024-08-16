package main.java;

import java.io.IOException;

public class Main7 {
    public static void main(String[] args) {
        String csvPath = "/Users/valentindamache/Desktop/Java/assignments/Java/week8/skibiathlonstandings/src/main/resources/athletes.csv";
        try {
            BiathlonAthletesCSVParser csvParser = new BiathlonAthletesCSVParser(csvPath);
            csvParser.parseCSVAndAddObjectsToList();
            System.out.println(csvParser);
            System.out.println();
            csvParser.getFirstThreeAthletesByScore();
        } catch (IOException | EmptyCSVException e) {
            System.out.println("Exception error caught: " + e);
        }
    }
}
