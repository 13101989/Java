package main.java;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class Athlete {
    private final int number;
    private final String firstName;
    private final String lastName;
    private final Country countryCode;

    public void calculateScore() {
    }

}
