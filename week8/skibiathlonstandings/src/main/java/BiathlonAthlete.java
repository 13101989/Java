package main.java;

import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BiathlonAthlete extends Athlete implements Comparable<BiathlonAthlete> {

    @Getter
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
    private Duration score;

    @Getter
    private int penalty;

    public BiathlonAthlete(int number, String firstName, String lastName, Country countryCode) {
        super(number, firstName, lastName, countryCode);
        calculateScore();
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

        score = skiTimeResult.minusSeconds(penalty);
    }

    @Override
    public int compareTo(BiathlonAthlete biathlonAthlete) {
        return this.score.compareTo(biathlonAthlete.getScore());
    }

    @Override
    public String toString() {
        return "BiathlonAthlete{" +
                "number=" + this.getNumber() + ", " +
                "name=" + this.getFirstName() + " " + this.getLastName() + ", " +
                "countryCode=" + this.getCountryCode() + ", " +
                "skiTimeResult=" + this.getSkiTimeResult() + ", " +
                "shootingRangeScores=" +
                this.getFirstShootingRangeScore() + " " +
                this.getSecondShootingRangeScore() + " " +
                this.getThirdShootingRangeScore() + "}";
    }
}
