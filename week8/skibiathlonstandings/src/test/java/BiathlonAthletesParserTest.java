package test.java;

import main.java.BiathlonAthletesParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
    void canInstantiateBiathlonAthleteFromCsv(
            String number,
            String name,
            String countryCode,
            String skiTimeResult,
            String firstShootingRangeScore,
            String secondShootingRangeScore,
            String thirdShootingRangeScore,
            String expectedResult) {
        assertEquals(expectedResult, biathlonAthletes.getFirstThreeAthletesByScoreFromCSV(););
    }
}