package main.java;

import main.java.customexceptions.IllegalOrderConditionException;

import java.time.LocalDate;
import java.util.logging.Logger;

public class Main8 {
    private static final Logger logger = Logger.getLogger(Main8.class.getName());

    public static void main(String[] args) {
        Student student1 = new Student(
                "Ion",
                "Maria",
                LocalDate.of(1989, 10, 14),
                "male",
                "1111111111111");
        Student student2 = new Student(
                "Ioana",
                "Maria",
                LocalDate.of(1989, 10, 14),
                "F",
                "2222222222222");
        Student student3 = new Student(
                "Ana",
                "Aristide",
                LocalDate.of(1999, 10, 14),
                "female",
                "3333333333333");

        StudentRepo studentContainer = new StudentRepo();
        studentContainer.addStudent(student1);
        studentContainer.addStudent(student2);
        studentContainer.addStudent(student3);

        try {
            studentContainer.listStudentsOrderedBy("name");
        } catch (IllegalOrderConditionException e) {
            logger.severe("Exception caught: " + e);
        }

        try {
            studentContainer.listStudentsOrderedBy("age");
        } catch (IllegalOrderConditionException e) {
            logger.severe("Exception caught: " + e);
        }

        studentContainer.retrieveAllStudentsOfAge(34);

        studentContainer.deleteStudent("1111111111111");

        try {
            studentContainer.listStudentsOrderedBy("name");
        } catch (IllegalOrderConditionException e) {
            logger.severe("Exception caught: " + e);
        }

        studentContainer.retrieveAllStudentsOfAge(33);
    }
}
