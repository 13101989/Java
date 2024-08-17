package test.java;

import main.java.BiathlonAthletesParser;
import main.java.EmptyCSVException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
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

    @ParameterizedTest(name = "{7}")
    @CsvSource(value = {
            "11;    Athlete One;    DE;     30:27;      xxxox;      xxxxx;      xxoxo;      BiathlonAthlete{number=11, name=Athlete One, country=Germany, score=30:57, skiTimeResult=30:27, penalty=30 seconds, shootingRangeScores=xxxox xxxxx xxoxo}"
    }, delimiter = ';')
    void canReadAndInstantiateBiathlonAthleteFromCsvData(
            String number,
            String name,
            String countryCode,
            String skiTimeResult,
            String firstShootingRangeScore,
            String secondShootingRangeScore,
            String thirdShootingRangeScore,
            String expectedResult) throws EmptyCSVException {

        List<String> csvData = new ArrayList<>(
                List.of("AthleteNumber,AthleteName,CountryCode,SkiTimeResult(Minutes:Seconds),FirstShootingRange,SecondShooting,ThirdShooting"));
        csvData.add(number + "," + name + "," + countryCode + "," + skiTimeResult + "," + firstShootingRangeScore + "," + secondShootingRangeScore + "," + thirdShootingRangeScore);

        biathlonAthletes.getFirstThreeAthletesByScoreFromCSV(csvData);
        String result = biathlonAthletes.getBiathlonAthletes().get(0).toString();
        assertEquals(expectedResult, result);
    }
}