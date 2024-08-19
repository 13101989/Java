package test.java;

import main.java.Student;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StudentTest {
    private Student student;

    @Test
    void canInstantiateScenarios() {
        /*
         * Test that student can instantiate with gender written with uppercase and lowercase letters.
         */
        assertNotNull(student = new Student(
                "Ion",
                "Maria",
                LocalDate.of(1989, 10, 13),
                "male",
                "1111111111111"));

        assertNotNull(student = new Student(
                "Ion",
                "Maria",
                LocalDate.of(1989, 10, 13),
                "mALe",
                "1111111111111"));

        assertNotNull(student = new Student(
                "Ion",
                "Maria",
                LocalDate.of(1989, 10, 13),
                "M",
                "1111111111111"));

        /*
         * Test that the firstName parameter is empty and throws an IllegalArgumentException.
         */
        assertThrows(IllegalArgumentException.class, () -> student = new Student(
                "",
                "Maria",
                LocalDate.of(1989, 10, 13),
                "male",
                "1111111111111"));

        /*
         * Test that the lastName parameter is empty and throws an IllegalArgumentException.
         */
        assertThrows(IllegalArgumentException.class, () -> student = new Student(
                "Ion",
                "",
                LocalDate.of(1989, 10, 13),
                "male",
                "1111111111111"));

        /*
         * Test that the dateOfBirth os student is before year 1900 and throws an IllegalArgumentException.
         */
        assertThrows(IllegalArgumentException.class, () -> student = new Student(
                "Ion",
                "Maria",
                LocalDate.of(1889, 10, 13),
                "male",
                "1111111111111"));

        /*
         * Test that the student age parameter is under 18 and throws an IllegalArgumentException.
         */
        assertThrows(IllegalArgumentException.class, () -> student = new Student(
                "Ion",
                "Maria",
                LocalDate.of(2020, 10, 13),
                "male",
                "1111111111111"));

        /*
         * Test that the gender parameter is not one of 'm', 'male', 'f' and 'female' (case-insensitive) and throws an IllegalArgumentException.
         */
        assertThrows(IllegalArgumentException.class, () -> student = new Student(
                "Ion",
                "Maria",
                LocalDate.of(1989, 10, 13),
                "mal",
                "1111111111111"));

        /*
         * Test that the gender parameter is empty and throws an IllegalArgumentException.
         */
        assertThrows(IllegalArgumentException.class, () -> student = new Student(
                "Ion",
                "Maria",
                LocalDate.of(1989, 10, 13),
                "",
                "1111111111111"));
    }
}