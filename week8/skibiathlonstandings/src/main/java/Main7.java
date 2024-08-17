package main.java;

import java.io.IOException;
import java.util.Arrays;

public class Main7 {
    public static void main(String[] args) {
        String csvPath = "/Users/valentindamache/Desktop/Java/assignments/Java/week8/skibiathlonstandings/src/main/resources/athletes.csv";
        try {
            BiathlonAthletesParser biathlonAthletes = new BiathlonAthletesParser();
            biathlonAthletes.getFirstThreeAthletesByScoreFromCSV(csvPath);
            System.out.println();
            System.out.println(biathlonAthletes);
            System.out.println(biathlonAthletes.getBiathlonAthletes());
        } catch (IOException | EmptyCSVException e) {
            System.out.println("Exception error caught: " + e);
        }
    }
}
