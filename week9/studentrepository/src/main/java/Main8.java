package main.java;

import java.time.LocalDate;

public class Main8 {
    public static void main(String[] args) {
        Student student1 =
                new Student("Ion", "Maria", LocalDate.of(1989, 10, 13), "male", "1111111111111");
        Student student2 =
                new Student("Ioana", "Maria", LocalDate.of(1989, 10, 14), "F", "2222222222222");
        Student student3 =
                new Student("Ana", "Aristide", LocalDate.of(1999, 10, 14), "female", "3333333333333");

        StudentRepo studentContainer = new StudentRepo();
        studentContainer.addStudent(student1);
        studentContainer.addStudent(student2);
        studentContainer.addStudent(student3);

        System.out.println();
        studentContainer.listStudentsOrderedBy("lastname");

        System.out.println();
        studentContainer.listStudentsOrderedBy("dateOfBirth");

        System.out.println();
        studentContainer.retrieveAllStudentsOfAge(34);

        System.out.println();
        studentContainer.deleteStudent("1111111111111");

        System.out.println();
        studentContainer.listStudentsOrderedBy("lastName");

        System.out.println();
        studentContainer.retrieveAllStudentsOfAge(33);
    }
}
