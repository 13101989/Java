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
                "Winner - " + winner.getFirstName() + " " + winner.getLastName() + " " + winner.getScore() +
                        " (" + winner.getSkiTimeResult() + " + " + winner.getPenalty() + ")");
        System.out.println(
                "Runner-up - " + runnerUp.getFirstName() + " " + runnerUp.getLastName() + " " + runnerUp.getScore() +
                        " (" + runnerUp.getSkiTimeResult() + " + " + runnerUp.getPenalty() + ")");
        System.out.println(
                "Third Place - " + thirdPlace.getFirstName() + " " + thirdPlace.getLastName() + " " + thirdPlace.getScore() +
                        " (" + thirdPlace.getSkiTimeResult() + " + " + thirdPlace.getPenalty() + ")");
    }

    private List<BiathlonAthlete> parseCSVAndAddObjectsToList() throws IOException {
        List<BiathlonAthlete> biathlonAthletes = new ArrayList<>();
        Path fileToRead = Paths.get(this.csvFilePath);
        List<String> lines = Files.readAllLines(fileToRead);

        for (int i = 1; i < lines.size(); i++) {
            String[] athleteData = lines.get(i).split(",");
            BiathlonAthlete biathlonAthlete = instantiateBiathlonAthleteFromCsvLineData(athleteData);
            biathlonAthletes.add(biathlonAthlete);
        }
        return biathlonAthletes;
    }

    private BiathlonAthlete instantiateBiathlonAthleteFromCsvLineData (String[] athleteData){
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
}
