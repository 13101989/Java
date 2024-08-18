package main.java;

import java.util.*;

public class StudentRepo {
    public List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student " + student + " was added successfully.");
    }

    public void deleteStudent(String id) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getId().equals(id)) {
                iterator.remove();
                System.out.println(student + " was deleted successfully.");
                break;
            }
        }
    }

    public void retrieveAllStudentsOfAge(int age) {
        boolean atLeastOneStudendOfAge = false;

        System.out.println("The following students have age " + age + ":");
        for (Student student : students) {
            if (student.calculateAge().get("years") == age) {
                System.out.println(student);
                atLeastOneStudendOfAge = true;
            }
        }

        if (!atLeastOneStudendOfAge) {
            System.out.println("There are no students of age " + age);
        }
    }

    public void listStudentsOrderedBy(String orderCondition) {
        System.out.println("Sorted students by " + orderCondition + ":");

        if (orderCondition.equalsIgnoreCase("lastName")) {
            students.sort(Comparator.comparing(Student::getLastName));
            for (Student student : students) {
                System.out.println(student);
            }
        } else if (orderCondition.equalsIgnoreCase("dateOfBirth")) {
            students.sort(Comparator.comparing(Student::getDateOfBirth).reversed());
            for (Student student : students) {
                Map<String, Integer> studentAge = student.calculateAge();
                System.out.println(student + " -> " +
                        studentAge.get("years") + " years " + studentAge.get("months") + " months " + studentAge.get("days") + " days.");
            }
        }

    }
}
