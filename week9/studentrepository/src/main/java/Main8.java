package main.java;

import java.time.LocalDate;

public class Main8 {
    public static void main(String[] args) {
        Student student1 =
                new Student("Maria", "Ion", LocalDate.of(1989, 10, 13), "male", "1111111111111");
        Student student2 =
                new Student("Maria", "Ioana", LocalDate.of(1989, 10, 14), "female", "2222222222222");

        StudentRepo studentContainer = new StudentRepo();
        studentContainer.addStudent(student1);
        studentContainer.addStudent(student2);

        System.out.println();
        studentContainer.listStudentsOrderedBy("lastName");

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
