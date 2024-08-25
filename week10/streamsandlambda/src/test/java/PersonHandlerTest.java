package test.java;

import main.java.PersonHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PersonHandlerTest {
    private PersonHandler personContainer;

    @BeforeEach
    void setUp() {
        personContainer = new PersonHandler();
    }

    @Test
    void canInstantiate() {
        assertNotNull(personContainer);
    }


    @ParameterizedTest(name = "Born in February: George, Mirela, Valentin, Valentin")
    @CsvSource(value = {
            "11,Mihai,Dumitru,1990,1,27;" +
                    "12,Valentin,Tanasie,2002,2,10;" +
                    "13,Mirela,Tanase,2000,2,12;" +
                    "14,George,State,2002,2,24;" +
                    "15,Valentin,Tanase,2002,2,2;" +
                    "16,Ioana,Melinte,1989,12,10;" +

                    "[" +
                    "Persons that are born in FEBRUARY ordered alphabetically:, " +
                    "George State -> 2002-02-24, " +
                    "Mirela Tanase -> 2000-02-12, " +
                    "Valentin Tanase -> 2002-02-02, " +
                    "Valentin Tanasie -> 2002-02-10" +
                    "];"

    }, delimiter = ';')
    void findAndReturnPersonsBornInFebruary(
            String person1,
            String person2,
            String person3,
            String person4,
            String person5,
            String person6,
            String expected
    ) throws IOException {

        List<String> csvData = List.of(person1, person2, person3, person4, person5, person6);

        List<String> actual = personContainer.findAndReturnPersonsBornInSpecificMonth(csvData, 2);
        assertEquals(expected, actual.toString());
    }


    @ParameterizedTest(name = "Born in December: Ioana")
    @CsvSource(value = {
            "11,Mihai,Dumitru,1990,1,27;" +
                    "12,Valentin,Tanasie,2002,2,10;" +
                    "13,Mirela,Tanase,2000,2,12;" +
                    "14,George,State,2002,2,24;" +
                    "15,Valentin,Tanase,2002,2,2;" +
                    "16,Ioana,Melinte,1989,12,10;" +

                    "[" +
                    "Persons that are born in DECEMBER ordered alphabetically:, " +
                    "Ioana Melinte -> 1989-12-10" +
                    "];"

    }, delimiter = ';')
    void findAndReturnPersonsBornInDecember(
            String person1,
            String person2,
            String person3,
            String person4,
            String person5,
            String person6,
            String expected
    ) throws IOException {

        List<String> csvData = List.of(person1, person2, person3, person4, person5, person6);

        List<String> actual = personContainer.findAndReturnPersonsBornInSpecificMonth(csvData, 12);
        assertEquals(expected, actual.toString());
    }

    @ParameterizedTest(name = "Born in December: Ioana")
    @CsvSource(value = {
            "11,Mihai,Dumitru,1990,1,27;" +
                    "12,Valentin,Tanasie,2002,2,10;" +
                    "13,Mirela,Tanase,2000,2,12;" +
                    "14,George,State,2002,2,24;" +
                    "15,Valentin,Tanase,2002,2,2;" +
                    "16,Ioana,Melinte,1989,12,10;" +

                    "[" +
                    "No person from list provided is born in the month of APRIL" +
                    "];"

    }, delimiter = ';')
    void findAndReturnPersonsBornInApril(
            String person1,
            String person2,
            String person3,
            String person4,
            String person5,
            String person6,
            String expected
    ) throws IOException {

        List<String> csvData = List.of(person1, person2, person3, person4, person5, person6);

        List<String> actual = personContainer.findAndReturnPersonsBornInSpecificMonth(csvData, 4);
        assertEquals(expected, actual.toString());
    }
}
