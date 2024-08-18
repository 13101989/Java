package main.java;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

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
                System.out.println("Student " + student + " was deleted successfully.");
                break;
            }
        }
    }

    public void retrieveAllStudentsOfAge(int age) {
        boolean atLeastOneStudendOfAge = false;

        System.out.println("The following students have age " + age + ":");
        for (Student student : students) {
            if (student.calculateAge() == age) {
                System.out.println(student);
                atLeastOneStudendOfAge = true;
            }
        }

        if (!atLeastOneStudendOfAge) {
            System.out.println("There are no students of age " + age);
        }
    }

    public void listStudentsOrderedBy(String orderCondition) {
        System.out.println("Sorted students by " + orderCondition);

        if (orderCondition.equals("lastName")) {
            students.sort(Comparator.comparing(Student::getLastName));
        } else if (orderCondition.equals("dateOfBirth")) {
            students.sort(Comparator.comparing(Student::getDateOfBirth));
        }
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
