package test.java;

import main.java.StudentRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class StudentRepoTest {
    private StudentRepo studentRepoo;

    @BeforeEach
    void setUp() {
        studentRepoo = new StudentRepo();
    }

    @Test
    void canInstantiate() {
        assertNotNull(studentRepoo);
    }

    @Test
    void testAddStudent() {
    }

    @Test
    void deleteStudent() {
    }

    @Test
    void retrieveAllStudentsOfAge() {
    }

    @Test
    void listStudentsOrderedBy() {
    }
}