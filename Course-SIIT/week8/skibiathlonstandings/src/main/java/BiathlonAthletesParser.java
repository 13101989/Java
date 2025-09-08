package main.java;

import lombok.Getter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Getter
public class BiathlonAthletesParser {

    private final List<BiathlonAthlete> biathlonAthletes = new ArrayList<>();

    public void getFirstThreeAthletesByScoreFromCSV(String csvFilePath) throws IOException, EmptyCSVException {
        parseBiathlonAthletesFromCSV(csvFilePath);
        biathlonAthletes.sort(null);

        if (biathlonAthletes.size() > 2) {
            BiathlonAthlete winner = biathlonAthletes.get(0);
            BiathlonAthlete runnerUp = biathlonAthletes.get(1);
            BiathlonAthlete thirdPlace = biathlonAthletes.get(2);

            System.out.println("First three athletes by score are:");
            System.out.println(
                    "Winner - " + winner.getFirstName() + " " + winner.getLastName() + " " + winner.getScore() +
                            " (" + winner.getSkiTimeResult() + " + " + winner.getPenalty() + ")");
            System.out.println(
                    "Runner-up - " + runnerUp.getFirstName() + " " + runnerUp.getLastName() + " " + runnerUp.getScore() +
                            " (" + runnerUp.getSkiTimeResult() + " + " + runnerUp.getPenalty() + ")");
            System.out.println(
                    "Third Place - " + thirdPlace.getFirstName() + " " + thirdPlace.getLastName() + " " + thirdPlace.getScore() +
                            " (" + thirdPlace.getSkiTimeResult() + " + " + thirdPlace.getPenalty() + ")");
        } else {
            System.out.println("Cannot return podium as number of athletes provided is less than 3");
        }
    }

    public void getFirstThreeAthletesByScoreFromCSV(List<String> csvData) throws EmptyCSVException {
        parseBiathlonAthletesFromCSV(csvData);
        biathlonAthletes.sort(null);

        if (biathlonAthletes.size() > 2) {
            BiathlonAthlete winner = biathlonAthletes.get(0);
            BiathlonAthlete runnerUp = biathlonAthletes.get(1);
            BiathlonAthlete thirdPlace = biathlonAthletes.get(2);

            System.out.println("First three athletes by score are:");
            System.out.println(
                    "Winner - " + winner.getFirstName() + " " + winner.getLastName() + " " + winner.getScore() +
                            " (" + winner.getSkiTimeResult() + " + " + winner.getPenalty() + ")");
            System.out.println(
                    "Runner-up - " + runnerUp.getFirstName() + " " + runnerUp.getLastName() + " " + runnerUp.getScore() +
                            " (" + runnerUp.getSkiTimeResult() + " + " + runnerUp.getPenalty() + ")");
            System.out.println(
                    "Third Place - " + thirdPlace.getFirstName() + " " + thirdPlace.getLastName() + " " + thirdPlace.getScore() +
                            " (" + thirdPlace.getSkiTimeResult() + " + " + thirdPlace.getPenalty() + ")");
        } else {
            System.out.println("Cannot return podium as number of athletes provided is less than 3");
        }
    }

    private void parseBiathlonAthletesFromCSV(String csvFilePath) throws IOException, EmptyCSVException {
        String csvDelimiter = ",";
        Path fileToRead = Paths.get(csvFilePath);
        List<String> lines = Files.readAllLines(fileToRead);

        if (lines.size() < 2) {
            throw new EmptyCSVException("CSV is empty.");
        }

        for (int i = 1; i < lines.size(); i++) {
            String[] athleteData = lines.get(i).split(csvDelimiter);
            BiathlonAthlete biathlonAthlete = instantiateBiathlonAthleteFromCsv(athleteData);
            biathlonAthletes.add(biathlonAthlete);
        }
    }

    private void parseBiathlonAthletesFromCSV(List<String> csvData) throws EmptyCSVException {
        String csvDelimiter = ",";

        if (csvData.size() < 2) {
            throw new EmptyCSVException("CSV is empty.");
        }

        for (int i = 1; i < csvData.size(); i++) {
            String[] athleteData = csvData.get(i).split(csvDelimiter);
            BiathlonAthlete biathlonAthlete = instantiateBiathlonAthleteFromCsv(athleteData);
            biathlonAthletes.add(biathlonAthlete);
        }
    }

    private BiathlonAthlete instantiateBiathlonAthleteFromCsv(String[] athleteData) {
        int number = Integer.parseInt(athleteData[0]);
        String firstName = athleteData[1].split(" ")[0];
        String lastName = athleteData[1].split(" ")[1];
        Country countryCode = Country.valueOf(athleteData[2]);
        int minutes = Integer.parseInt(athleteData[3].split(":")[0]);
        int seconds = Integer.parseInt(athleteData[3].split(":")[1]);
        Duration skiTimeResult = Duration.ofMinutes(minutes).plusSeconds(seconds);
        String firstShootingRangeScore = athleteData[4];
        String secondShootingRangeScore = athleteData[5];
        String thirdShootingRangeScore = athleteData[6];

        BiathlonAthlete biathlonAthlete = new BiathlonAthlete(number, firstName, lastName, countryCode);
        biathlonAthlete.setSkiTimeResult(skiTimeResult);
        biathlonAthlete.setFirstShootingRangeScore(firstShootingRangeScore);
        biathlonAthlete.setSecondShootingRangeScore(secondShootingRangeScore);
        biathlonAthlete.setThirdShootingRangeScore(thirdShootingRangeScore);
        biathlonAthlete.calculateScore();

        return biathlonAthlete;
    }

    public String toString() {
        StringBuilder result = new StringBuilder("CSV file contains following biathlon athletes:\n");
        for (BiathlonAthlete biathlonAthlete : biathlonAthletes) {
            result.append(biathlonAthlete.toString()).append("\n");
        }
        return result.toString();
    }
}
