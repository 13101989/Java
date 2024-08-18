package test.java;

import main.java.BiathlonAthletesParser;
import main.java.EmptyCSVException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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

    @ParameterizedTest(name = "assertEquals on {0}")
    @CsvSource(value = {
            "11,Athlete One,DE,30:27,xxxox,xxxxx,xxoxo;      BiathlonAthlete{number=11, name=Athlete One, country=Germany, score=30:57, skiTimeResult=30:27, penalty=30 seconds, shootingRangeScores=xxxox xxxxx xxoxo}",
            "12,Athlete Two,UK,29:15,xxoox,xooxo,xxxxo;      BiathlonAthlete{number=12, name=Athlete Two, country=United Kingdom, score=30:15, skiTimeResult=29:15, penalty=60 seconds, shootingRangeScores=xxoox xooxo xxxxo}",
            "16,Athlete Six,SE,29:59,xxxxx,ooooo,xxxxx;      BiathlonAthlete{number=16, name=Athlete Six, country=Sweden, score=30:49, skiTimeResult=29:59, penalty=50 seconds, shootingRangeScores=xxxxx ooooo xxxxx}"
    }, delimiter = ';')
    void canReadAndInstantiateBiathlonAthleteFromCsvData(
            String athleteData,
            String expectedResult) throws EmptyCSVException {

        List<String> csvData = new ArrayList<>(
                List.of("AthleteNumber,AthleteName,CountryCode,SkiTimeResult(Minutes:Seconds),FirstShootingRange,SecondShooting,ThirdShooting"));
        csvData.add(athleteData);

        biathlonAthletes.getFirstThreeAthletesByScoreFromCSV(csvData);

        String result = biathlonAthletes.getBiathlonAthletes().get(0).toString();
        assertEquals(expectedResult, result);
    }

    @ParameterizedTest(name = "1:two,  2:six,  3:one")
    @CsvSource(value = {
            "11,Athlete One,DE,30:27,xxxox,xxxxx,xxoxo;     12,Athlete Two,UK,29:15,xxoox,xooxo,xxxxo;      16,Athlete Six,SE,29:59,xxxxx,ooooo,xxxxx;     " +
                    "[BiathlonAthlete{number=12, name=Athlete Two, country=United Kingdom, score=30:15, skiTimeResult=29:15, penalty=60 seconds, shootingRangeScores=xxoox xooxo xxxxo}, " +
                    "BiathlonAthlete{number=16, name=Athlete Six, country=Sweden, score=30:49, skiTimeResult=29:59, penalty=50 seconds, shootingRangeScores=xxxxx ooooo xxxxx}, " +
                    "BiathlonAthlete{number=11, name=Athlete One, country=Germany, score=30:57, skiTimeResult=30:27, penalty=30 seconds, shootingRangeScores=xxxox xxxxx xxoxo}]"
    }, delimiter = ';')
    void canReadAndInstantiateMultipleBiathlonAthletesFromCsvData(
            String athlete1,
            String athlete2,
            String athlete3,
            String expectedResult) throws EmptyCSVException {

        List<String> csvData = new ArrayList<>(
                List.of("AthleteNumber,AthleteName,CountryCode,SkiTimeResult(Minutes:Seconds),FirstShootingRange,SecondShooting,ThirdShooting"));
        csvData.add(athlete1);
        csvData.add(athlete2);
        csvData.add(athlete3);

        biathlonAthletes.getFirstThreeAthletesByScoreFromCSV(csvData);

        String result = biathlonAthletes.getBiathlonAthletes().toString();
        assertEquals(expectedResult, result);
    }

    @ParameterizedTest(name = "1:four, 2:two, 3:three")
    @CsvSource(value = {
            "11,Athlete One,DE,30:27,xxxox,xxxxx,xxoxo; " +
                    "12,Athlete Two,UK,29:15,xxoox,xooxo,xxxxo; " +
                    "13,Athlete Three,NO,30:10,xxxxx,xoxxx,xoxxo; " +
                    "14,Athlete Four,RO,29:27,xxxxx,xxxxx,xxxxx; " +
                    "16,Athlete Six,SE,29:59,xxxxx,ooooo,xxxxx; " +

                    "BiathlonAthlete{number=14, name=Athlete Four, country=Romania, score=29:27, skiTimeResult=29:27, penalty=0 seconds, shootingRangeScores=xxxxx xxxxx xxxxx}; " +
                    "BiathlonAthlete{number=12, name=Athlete Two, country=United Kingdom, score=30:15, skiTimeResult=29:15, penalty=60 seconds, shootingRangeScores=xxoox xooxo xxxxo}; " +
                    "BiathlonAthlete{number=13, name=Athlete Three, country=Norway, score=30:40, skiTimeResult=30:10, penalty=30 seconds, shootingRangeScores=xxxxx xoxxx xoxxo}; "
    }, delimiter = ';')
    void testGetFirstThreeAthletesByScoreFromCSV(
            String athlete1,
            String athlete2,
            String athlete3,
            String athlete4,
            String athlete5,
            String expectedWinner,
            String expectedRunnerUp,
            String expectedThirdPlace) throws EmptyCSVException {

        List<String> csvData = new ArrayList<>(
                List.of("AthleteNumber,AthleteName,CountryCode,SkiTimeResult(Minutes:Seconds),FirstShootingRange,SecondShooting,ThirdShooting"));
        csvData.add(athlete1);
        csvData.add(athlete2);
        csvData.add(athlete3);
        csvData.add(athlete4);
        csvData.add(athlete5);

        biathlonAthletes.getFirstThreeAthletesByScoreFromCSV(csvData);

        String actualWinner = biathlonAthletes.getBiathlonAthletes().get(0).toString();
        String actualRunnerUp = biathlonAthletes.getBiathlonAthletes().get(1).toString();
        String actualThirdPlace = biathlonAthletes.getBiathlonAthletes().get(2).toString();

        assertEquals(expectedWinner, actualWinner);
        assertEquals(expectedRunnerUp, actualRunnerUp);
        assertEquals(expectedThirdPlace, actualThirdPlace);
    }

    @Test
    void testCSVDataIsEmptyException() {

        List<String> csvData = new ArrayList<>(
                List.of("AthleteNumber,AthleteName,CountryCode,SkiTimeResult(Minutes:Seconds),FirstShootingRange,SecondShooting,ThirdShooting"));

        assertThrows(EmptyCSVException.class, () -> biathlonAthletes.getFirstThreeAthletesByScoreFromCSV(csvData));
    }
}