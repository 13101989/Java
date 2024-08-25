package main.java;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
public class Person implements Comparable<Person> {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;

    @Override
    public int compareTo(Person person) {
        int firstNameComparison = this.firstName.compareTo(person.firstName);

        if (firstNameComparison != 0) {
            return firstNameComparison;
        } else {
            return this.lastName.compareTo(person.lastName);
        }
    }

    @Override
    public String toString() {
        return this.getFirstName() + " " + this.getLastName() + " -> " + this.getDateOfBirth();
    }
}


