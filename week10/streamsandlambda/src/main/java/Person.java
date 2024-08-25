package main.java;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
@Data
public class Person {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
}


