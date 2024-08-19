package main.java;

import main.java.customexceptions.IllegalOrderConditionException;

import java.util.*;

public class StudentRepo {
    public List<Student> students = new ArrayList<>();

    public void addStudent(Student newStudent) {
        for (Student student : students) {
            if (student.getId().equals(newStudent.getId())) {
                throw new IllegalArgumentException("A student with ID '" + newStudent.getId() + "' already exists, id of student should be unique.");
            }
        }

        students.add(newStudent);
        System.out.println("Student " + newStudent + " was added successfully.");
    }

    public void deleteStudent(String id) {
        if (id.isEmpty()) {
            throw new IllegalArgumentException("Id value cannot be empty");
        }

        boolean found = false;
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getId().equals(id)) {
                found = true;
                iterator.remove();
                System.out.println(student + " was deleted successfully.");
                break;
            }
        }

        if (!found) {
            throw new NoSuchElementException("Student with id " + id + " not found.");
        }
    }

    public List<Student> retrieveAllStudentsOfAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be a negative number. Age provided '" + age + "'.");
        }

        List<Student> studentsOfAge = new ArrayList<>();
        System.out.println("The following students have age " + age + " years:");

        for (Student student : students) {
            if (student.calculateAge().get("years") == age) {
                System.out.println(student);
                studentsOfAge.add(student);
            }
        }

        if (studentsOfAge.isEmpty()) {
            System.out.println("There are no students of age " + age);
        }
        return studentsOfAge;
    }

    public void listStudentsOrderedBy(String orderCondition) throws IllegalOrderConditionException {
        System.out.println("Sorted students by " + orderCondition + ":");

        if (orderCondition.equalsIgnoreCase("name")) {
            students.sort(Comparator.comparing(Student::getLastName)
                    .thenComparing(Student::getFirstName));
            for (Student student : students) {
                System.out.println(student);
            }

        } else if (orderCondition.equalsIgnoreCase("age")) {
            students.sort(Comparator.comparing(Student::getDateOfBirth)
                    .reversed()
                    .thenComparing(Student::getLastName)
                    .thenComparing(Student::getFirstName));
            for (Student student : students) {
                Map<String, Integer> studentAge = student.calculateAge();
                System.out.println(student + " -> " +
                        studentAge.get("years") + " years " + studentAge.get("months") + " months " + studentAge.get("days") + " days.");
            }
        } else if (orderCondition.isEmpty()) {
            throw new IllegalArgumentException("Order condition cannot be empty. You can only choose between 'name' and 'age'.");
        } else {
            throw new IllegalOrderConditionException("Input order condition can only be one of 'name' and 'age' values");
        }
    }
}
