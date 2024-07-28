package test.java;

import main.java.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void set_up(){
        calculator = new Calculator();
    }

    @Test
    @DisplayName("add: 1 m + 2 mm = 1.002 m")
    void add() {
        assertEquals("1 m + 2 mm = 1.002 m", calculator.add(1, "m", 2, "mm", "m"));
    }

    @Test
    @DisplayName("subtract: 1 cm - 2 mm = 0.8 cm")
    void subtract() {
        assertEquals("1 cm - 2 mm = 0.8 cm", calculator.subtract(1, "cm", 2, "mm", "cm"));
    }
}