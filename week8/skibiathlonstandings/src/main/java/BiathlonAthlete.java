package main.java;

import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BiathlonAthlete extends Athlete implements Comparable<BiathlonAthlete> {

    @Setter
    private Duration skiTimeResult;

    @Getter
    @Setter
    private String firstShootingRangeScore;

    @Getter
    @Setter
    private String secondShootingRangeScore;

    @Getter
    @Setter
    private String thirdShootingRangeScore;

    @Getter
    private int penalty;

    private Duration score;

    public BiathlonAthlete(int number, String firstName, String lastName, Country countryCode) {
        super(number, firstName, lastName, countryCode);
    }

    @Override
    public void calculateScore() {
        penalty = 0;
        List<String> scores = new ArrayList<>();
        scores.add(firstShootingRangeScore);
        scores.add(secondShootingRangeScore);
        scores.add(thirdShootingRangeScore);

        for (String shootingRange : scores) {
            for (char shootResult : shootingRange.toCharArray()) {
                if (shootResult == 'o') {
                    penalty += 10;
                }
            }
        }

        score = skiTimeResult.plusSeconds(penalty);
    }

    @Override
    public int compareTo(BiathlonAthlete biathlonAthlete) {
        return this.score.compareTo(biathlonAthlete.score);
    }

    @Override
    public String toString() {
        return "BiathlonAthlete{" +
                "number=" + this.getNumber() + ", " +
                "name=" + this.getFirstName() + " " + this.getLastName() + ", " +
                "countryCode=" + this.getCountryCode() + ", " +
                "score=" + this.getScore() + ", " +
                "skiTimeResult=" + this.getSkiTimeResult() + ", " +
                "penalty=" + this.getPenalty() + " seconds, " +
                "shootingRangeScores=" +
                this.getFirstShootingRangeScore() + " " +
                this.getSecondShootingRangeScore() + " " +
                this.getThirdShootingRangeScore() + "}";
    }

    public String durationToStringConverter(Duration duration) {
        long minutes = duration.toMinutes();
        long seconds = duration.minusMinutes(minutes).getSeconds();
        return minutes + ":" + seconds;
    }

    public String getSkiTimeResult() {
        return durationToStringConverter(this.skiTimeResult);
    }

    public String getScore() {
        return durationToStringConverter(this.score);
    }
}
