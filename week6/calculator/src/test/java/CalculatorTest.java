package test.java;

import main.java.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void set_up() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("add: 1 m + 2 mm = 1.002 m")
    void add() {
        assertEquals("1 m + 2 mm = 1.002 m", calculator.add(1, "m", 2, "mm", "m"));
    }

    @ParameterizedTest(name = "{0} {1} + {2} {3} in {4} => {5}")
    @CsvSource({
            "1,     m,      2,      mm,     m,      1 m + 2 mm = 1.002 m",
            "100,   mm,     2,      m,      dm,     100 mm + 2 m = 21.0 dm",
            "7,     cm,     1,      m,      mm,     7 cm + 1 m = 1070.0 mm"
    })
    void addParametrized(int first, String second, int third, String fourth, String fifth, String expectedResult) {
        assertEquals(expectedResult, calculator.add(first, second, third, fourth, fifth));
    }

    @Test
    @DisplayName("subtract: 1 cm - 2 mm = 0.8 cm")
    void subtract() {
        assertEquals("1 cm - 2 mm = 0.8 cm", calculator.subtract(1, "cm", 2, "mm", "cm"));
    }

    @ParameterizedTest(name = "{0} {1} - {2} {3} in {4} => {5}")
    @CsvSource({
            "1,     cm,     2,      mm,     cm,     1 cm - 2 mm = 0.8 cm",
            "6,     cm,     2,      m,      cm,     6 cm - 2 m = -194.0 cm",
            "3000,  mm,     2,      m,      km,     3000 mm - 2 m = 0.001 km"
    })
    void subtractParametrized(int first, String second, int third, String fourth, String fifth, String expectedResult) {
        assertEquals(expectedResult, calculator.subtract(first, second, third, fourth, fifth));
    }

    @Test
    void addWrongUnitFail() {
        assertEquals("Please enter a valid unit (supported formats: mm, cm, dm, m, km).",
                calculator.add(1, "m", 2, "mm", "hm"));
    }

    @Test
    void subtractWrongUnitFail() {
        assertEquals("Please enter a valid unit (supported formats: mm, cm, dm, m, km).",
                calculator.subtract(1, "cm", 2, "hm", "cm"));
    }
}
