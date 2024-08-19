package test.java;

import main.java.Student;
import main.java.StudentRepo;
import main.java.customexceptions.IllegalOrderConditionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class StudentRepoTest {
    private StudentRepo studentRepo;
    private Student student1;
    private Student student2;
    private Student student3;
    private Student student4;

    @BeforeEach
    void setUp() {
        studentRepo = new StudentRepo();
        student1 = new Student(
                "Ion",
                "Maria",
                LocalDate.of(1989, 10, 14),
                "male",
                "1111111111111");
        student2 = new Student(
                "Ioana",
                "Maria",
                LocalDate.of(1989, 10, 14),
                "F",
                "2222222222222");
        student3 = new Student(
                "Ana",
                "Aristide",
                LocalDate.of(1999, 10, 14),
                "female",
                "3333333333333");
        student4 = new Student(
                "Mihai",
                "Zainea",
                LocalDate.of(2000, 10, 14),
                "m",
                "4444444444444");
        studentRepo.addStudent(student1);
        studentRepo.addStudent(student2);
        studentRepo.addStudent(student3);
        studentRepo.addStudent(student4);
    }

    @Test
    void canInstantiate() {
        assertNotNull(studentRepo);
        assertNotNull(student1);
        assertNotNull(student2);
        assertNotNull(student3);
        assertNotNull(student4);
    }

    @Test
    void testAddStudent() {
        assertEquals(
                "Student(firstName=Ion, lastName=Maria, dateOfBirth=1989-10-14, gender=male, id=1111111111111)",
                studentRepo.students.get(0).toString());
        assertEquals(
                "Student(firstName=Ioana, lastName=Maria, dateOfBirth=1989-10-14, gender=F, id=2222222222222)",
                studentRepo.students.get(1).toString());
        assertEquals(
                "Student(firstName=Ana, lastName=Aristide, dateOfBirth=1999-10-14, gender=female, id=3333333333333)",
                studentRepo.students.get(2).toString());
        assertEquals(
                "Student(firstName=Mihai, lastName=Zainea, dateOfBirth=2000-10-14, gender=m, id=4444444444444)",
                studentRepo.students.get(3).toString());
    }

    @Test
    void deleteStudentScenarios() {
        studentRepo.deleteStudent("1111111111111");
        assertEquals(3, studentRepo.students.size());
        assertEquals(
                "Student(firstName=Ioana, lastName=Maria, dateOfBirth=1989-10-14, gender=F, id=2222222222222)",
                studentRepo.students.get(0).toString());

        assertThrows(IllegalArgumentException.class, () -> studentRepo.deleteStudent(""));

        assertThrows(NoSuchElementException.class, () -> studentRepo.deleteStudent("IdDoesNotExists"));
    }

    @Test
    void retrieveAllStudentsOfAgeScenarios() {
        List<Student> studentsOfAgeExpected = List.of(student1, student2);
        assertEquals(studentsOfAgeExpected, studentRepo.retrieveAllStudentsOfAge(34));

        studentsOfAgeExpected = List.of(student3);
        assertEquals(studentsOfAgeExpected, studentRepo.retrieveAllStudentsOfAge(24));

        studentsOfAgeExpected = List.of();
        assertEquals(studentsOfAgeExpected, studentRepo.retrieveAllStudentsOfAge(44));

        assertThrows(IllegalArgumentException.class, () -> studentRepo.retrieveAllStudentsOfAge(-34));
    }

    @Test
    void listStudentsOrderedByScenarios() throws IllegalOrderConditionException {
        studentRepo.listStudentsOrderedBy("name");
        assertEquals(
                "Student(firstName=Ana, lastName=Aristide, dateOfBirth=1999-10-14, gender=female, id=3333333333333)",
                studentRepo.students.get(0).toString());
        assertEquals(
                "Student(firstName=Ioana, lastName=Maria, dateOfBirth=1989-10-14, gender=F, id=2222222222222)",
                studentRepo.students.get(1).toString());
        assertEquals(
                "Student(firstName=Ion, lastName=Maria, dateOfBirth=1989-10-14, gender=male, id=1111111111111)",
                studentRepo.students.get(2).toString());
        assertEquals(
                "Student(firstName=Mihai, lastName=Zainea, dateOfBirth=2000-10-14, gender=m, id=4444444444444)",
                studentRepo.students.get(3).toString());


        studentRepo.listStudentsOrderedBy("age");
        assertEquals(
                "Student(firstName=Mihai, lastName=Zainea, dateOfBirth=2000-10-14, gender=m, id=4444444444444)",
                studentRepo.students.get(0).toString());
        assertEquals(
                "Student(firstName=Ana, lastName=Aristide, dateOfBirth=1999-10-14, gender=female, id=3333333333333)",
                studentRepo.students.get(1).toString());
        assertEquals(
                "Student(firstName=Ioana, lastName=Maria, dateOfBirth=1989-10-14, gender=F, id=2222222222222)",
                studentRepo.students.get(2).toString());
        assertEquals(
                "Student(firstName=Ion, lastName=Maria, dateOfBirth=1989-10-14, gender=male, id=1111111111111)",
                studentRepo.students.get(3).toString());


        assertThrows(IllegalArgumentException.class, () -> studentRepo.listStudentsOrderedBy(""));

        assertThrows(IllegalOrderConditionException.class, () -> studentRepo.listStudentsOrderedBy("notNameOrAge"));
    }
}