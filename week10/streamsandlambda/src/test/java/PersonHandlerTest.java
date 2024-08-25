package test.java;

import main.java.Person;
import main.java.PersonHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class PersonHandlerTest {
    private PersonHandler personContainer;
    private Person person1;
    private Person person2;
    private Person person3;
    private Person person4;
    private Person person5;
    private Person person6;

    @BeforeEach
    void setUp() {
        personContainer = new PersonHandler();

        person1 = new Person(
                "Mihai",
                "Dumitru",
                LocalDate.of(1990, 1, 27)
        );
        person2 = new Person(
                "Valentin",
                "Tanasie",
                LocalDate.of(2002, 2, 10)
        );
        person3 = new Person(
                "Mirela",
                "Tanase",
                LocalDate.of(2000, 2, 12)
        );
        person4 = new Person(
                "George",
                "State",
                LocalDate.of(2002, 2, 2)
        );
        person5 = new Person(
                "Valentin",
                "Tanase",
                LocalDate.of(2002, 2, 2)
        );
        person6 = new Person(
                "Ioana",
                "Melinte",
                LocalDate.of(1989, 12, 10)
        );

        personContainer.getPersons().add(person1);
        personContainer.getPersons().add(person2);
        personContainer.getPersons().add(person3);
        personContainer.getPersons().add(person4);
        personContainer.getPersons().add(person5);
        personContainer.getPersons().add(person6);
    }

    @Test
    void findAndWriteToFilePersonsBornInSpecificMonth() {
    }
}