package main.java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CSVWithBiathlonAthletesParser {
    private final String csvFilePath;

    public CSVWithBiathlonAthletesParser(String csvFilePath) {
        this.csvFilePath = csvFilePath;
    }

    public void getFirstThreeAthletesByScore() throws IOException {
        List<BiathlonAthlete> biathlonAthletes = parseCSVAndAddObjectsToList();
        biathlonAthletes.sort(null);

        BiathlonAthlete winner = biathlonAthletes.get(0);
        BiathlonAthlete runnerUp = biathlonAthletes.get(1);
        BiathlonAthlete thirdPlace = biathlonAthletes.get(2);

        System.out.println(
                "Winner - " + winner.getFirstName() + " " + winner.getLastName() + " " + winner.getSkiTimeResult() +
                        " (" + winner.getSkiTimeResult() + " + " + winner.getPenalty() + ")");
        System.out.println(
                "Runner-up - " + runnerUp.getFirstName() + " " + runnerUp.getLastName() + " " + runnerUp.getSkiTimeResult() +
                        " (" + runnerUp.getSkiTimeResult() + " + " + runnerUp.getPenalty() + ")");
        System.out.println(
                "Runner-up - " + thirdPlace.getFirstName() + " " + thirdPlace.getLastName() + " " + thirdPlace.getSkiTimeResult() +
                        " (" + thirdPlace.getSkiTimeResult() + " + " + thirdPlace.getPenalty() + ")");
    }

    private List<BiathlonAthlete> parseCSVAndAddObjectsToList() throws IOException {
        List<BiathlonAthlete> biathlonAthletes = new ArrayList<>();
        Path fileToRead = Paths.get(this.csvFilePath);
        List<String> lines = Files.readAllLines(fileToRead);

        for (String line : lines) {
            String[] athleteData = line.split(",");

            int number = Integer.parseInt(athleteData[0]);
            String firstName = athleteData[1].split(" ")[0];
            String lastName = athleteData[1].split(" ")[1];
            Country countryCode = Country.valueOf(athleteData[2]);
            Duration skiTimeResult = Duration.parse(athleteData[3]);
            String firstShootingRangeScore = athleteData[4];
            String secondShootingRangeScore = athleteData[5];
            String thirdShootingRangeScore = athleteData[6];

            BiathlonAthlete biathlonAthlete = new BiathlonAthlete(number, firstName, lastName, countryCode);
            biathlonAthlete.setSkiTimeResult(skiTimeResult);
            biathlonAthlete.setFirstShootingRangeScore(firstShootingRangeScore);
            biathlonAthlete.setSecondShootingRangeScore(secondShootingRangeScore);
            biathlonAthlete.setThirdShootingRangeScore(thirdShootingRangeScore);

            biathlonAthletes.add(biathlonAthlete);
        }
        return biathlonAthletes;
    }
}
