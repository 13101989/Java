package test.java;

import main.java.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void add() {
        Calculator calculator = new Calculator();
        assertEquals("1 m + 2 mm = 1.002 m", calculator.add(1, "m", 2, "mm", "m"));
    }

    @Test
    void subtract() {
        Calculator calculator = new Calculator();
        assertEquals("1 cm - 2 mm = 0.8 cm", calculator.subtract(1, "cm", 2, "mm", "cm"));
    }
}