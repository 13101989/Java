package test.java;

import main.java.PersonHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

    @Test
    void findAndWriteToFilePersonsBornInSpecificMonth() {
    }
}