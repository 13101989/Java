package main.java;

import java.time.LocalDate;

public class Main8 {
    public static void main(String[] args) {
        Student student = new Student("Maria", "Ion", LocalDate.of(1989, 10, 13), "female", "1111111111111");
        System.out.println("Student age = " + student.calculateAge() + " years");
    }
}
