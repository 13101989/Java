package main.java;

import main.java.customexceptions.IllegalOrderConditionException;

import java.util.*;
import java.util.logging.Logger;

public class StudentRepo {
    private static final Logger logger = Logger.getLogger(StudentRepo.class.getName());

    public List<Student> students = new ArrayList<>();

    public void addStudent(Student newStudent) {
        for (Student student : students) {
            if (student.getId().equals(newStudent.getId())) {
                String exceptionMessage = "IllegalArgumentException exception thrown: " +
                        "A student with ID '" + newStudent.getId() + "' already exists, id of student should be unique!";
                logger.severe(exceptionMessage);
                throw new IllegalArgumentException(exceptionMessage);
            }
        }

        students.add(newStudent);
        logger.info("Student " + newStudent + " was added successfully.");
    }

    public void deleteStudent(String id) {
        if (id.isEmpty()) {
            String exceptionMessage = "IllegalArgumentException exception thrown: Id value cannot be empty!";
            logger.severe(exceptionMessage);
            throw new IllegalArgumentException(exceptionMessage);
        }

        boolean found = false;
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getId().equals(id)) {
                found = true;
                iterator.remove();
                logger.info(student + " was deleted successfully.");
                break;
            }
        }

        if (!found) {
            String exceptionMessage = "IllegalArgumentException exception thrown: " +
                    "Student with id " + id + " not found!";
            logger.severe(exceptionMessage);
            throw new NoSuchElementException(exceptionMessage);
        }
    }

    public List<Student> retrieveAllStudentsOfAge(int age) {
        if (age < 0) {
            String exceptionMessage = "IllegalArgumentException exception thrown: " +
                    "Age cannot be a negative number. Age provided '" + age + "'!";
            logger.severe(exceptionMessage);
            throw new IllegalArgumentException(exceptionMessage);
        }

        List<Student> studentsOfAge = new ArrayList<>();
        logger.info("The following students have age " + age + " years:");

        for (Student student : students) {
            if (student.calculateAge().get("years") == age) {
                logger.info(student.toString());
                studentsOfAge.add(student);
            }
        }

        if (studentsOfAge.isEmpty()) {
            logger.warning("There are no students of age " + age);
        }
        return studentsOfAge;
    }

    public void listStudentsOrderedBy(String orderCondition) throws IllegalOrderConditionException {
        logger.info("Sorted students by " + orderCondition + ":");

        if (orderCondition.equalsIgnoreCase("name")) {
            students.sort(Comparator.comparing(Student::getLastName)
                    .thenComparing(Student::getFirstName));
            for (Student student : students) {
                logger.info(student.toString());
            }

        } else if (orderCondition.equalsIgnoreCase("age")) {
            students.sort(Comparator.comparing(Student::getDateOfBirth)
                    .reversed()
                    .thenComparing(Student::getLastName)
                    .thenComparing(Student::getFirstName));
            for (Student student : students) {
                Map<String, Integer> studentAge = student.calculateAge();
                logger.info(student + " -> " +
                        studentAge.get("years") + " years " + studentAge.get("months") + " months " + studentAge.get("days") + " days.");
            }
        } else if (orderCondition.isEmpty()) {
            String exceptionMessage = "IllegalArgumentException exception thrown: " +
                    "Order condition cannot be empty. You can only choose between 'name' and 'age'!";
            logger.severe(exceptionMessage);
            throw new IllegalArgumentException(exceptionMessage);
        } else {
            String exceptionMessage = "IllegalArgumentException exception thrown: " +
                    "Input order condition can only be one of 'name' and 'age' values!";
            logger.severe(exceptionMessage);
            throw new IllegalOrderConditionException(exceptionMessage);
        }
    }
}
