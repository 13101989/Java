package main.java;

import java.io.IOException;

public class Main7 {
    public static void main(String[] args) {
        String csvPath = "/Users/valentindamache/Desktop/Java/assignments/Java/week8/skibiathlonstandings/src/main/resources/athletes.csv";
        CSVWithBiathlonAthletesParser csvParser = new CSVWithBiathlonAthletesParser(csvPath);
        try {
            csvParser.getFirstThreeAthletesByScore();
        } catch (IOException e) {
            System.out.println("IOException error caught: " + e);
        }
    }
}
