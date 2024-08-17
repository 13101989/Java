package test.java;

import main.java.BiathlonAthletesParser;
import main.java.EmptyCSVException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class BiathlonAthletesParserTest {
    private BiathlonAthletesParser biathlonAthletes;

    @BeforeEach
    void setUp() {
        biathlonAthletes = new BiathlonAthletesParser();
    }

    @Test
    void canInstantiate() {
        assertNotNull(biathlonAthletes);
    }

    @Test
    @CsvSource({
            "11,    Athlete One,    DE,     30:27,      xxxox,      xxxxx,      xxoxo,      " +
                    "[" +
                    "BiathlonAthlete" +
                    "{" +
                    "number={0}, " +
                    "name={1}, " +
                    "country=Germany, " +
                    "score=30:57, " +
                    "skiTimeResult={3}, " +
                    "penalty=30 seconds, " +
                    "shootingRangeScores={4} {5} {6}" +
                    "}" +
                    "]"
    })
    void canInstantiateBiathlonAthleteFromCsvData(
            String number,
            String name,
            String countryCode,
            String skiTimeResult,
            String firstShootingRangeScore,
            String secondShootingRangeScore,
            String thirdShootingRangeScore,
            String expectedResult) throws EmptyCSVException {

        List<String> csvData = new ArrayList<>(
                List.of(
                        "AthleteNumber",
                        "AthleteName",
                        "CountryCode",
                        "SkiTimeResult(Minutes:Seconds)",
                        "FirstShootingRange",
                        "SecondShooting",
                        "ThirdShooting"));
        csvData.addAll(List.of(number, name, countryCode, skiTimeResult, firstShootingRangeScore, secondShootingRangeScore, thirdShootingRangeScore));

        biathlonAthletes.getFirstThreeAthletesByScoreFromCSV(csvData);
        String result = biathlonAthletes.getBiathlonAthletes().get(0).toString();
        assertEquals(expectedResult, result);
    }
}