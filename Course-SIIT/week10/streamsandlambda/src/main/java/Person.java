package main.java;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Comparator;

@AllArgsConstructor
@Getter
@Setter
public class Person {
    public static final Comparator<Person> PERSON_COMPARATOR =
            Comparator
                    .comparing(Person::getFirstName)
                    .thenComparing(Person::getLastName);

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;

    @Override
    public String toString() {
        return this.getFirstName() + " " + this.getLastName() + " -> " + this.getDateOfBirth();
    }
}


