package main.java;

import java.util.*;

public class StudentRepo {
    public List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student " + student + " was added successfully.");
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

    public void retrieveAllStudentsOfAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be a negative number. Age provided '" + age + "'.");
        }

        boolean atLeastOneStudentOfAge = false;
        System.out.println("The following students have age " + age + " years:");

        for (Student student : students) {
            if (student.calculateAge().get("years") == age) {
                System.out.println(student);
                atLeastOneStudentOfAge = true;
            }
        }

        if (!atLeastOneStudentOfAge) {
            System.out.println("There are no students of age " + age);
        }
    }

    public void listStudentsOrderedBy(String orderCondition) throws InputOrderConditionException {
        System.out.println("Sorted students by " + orderCondition + ":");

        if (orderCondition.equalsIgnoreCase("name")) {
            students.sort(Comparator.comparing(Student::getLastName));
            for (Student student : students) {
                System.out.println(student);
            }
        } else if (orderCondition.equalsIgnoreCase("age")) {
            students.sort(Comparator.comparing(Student::getDateOfBirth).reversed());
            for (Student student : students) {
                Map<String, Integer> studentAge = student.calculateAge();
                System.out.println(student + " -> " +
                        studentAge.get("years") + " years " + studentAge.get("months") + " months " + studentAge.get("days") + " days.");
            }
        } else if (orderCondition.isEmpty()) {
            throw new IllegalArgumentException("Order condition cannot be empty. You can only choose between 'name' and 'age'.");
        } else {
            throw new InputOrderConditionException("Input order condition can only be one of 'name' and 'age' values");
        }
    }
}
