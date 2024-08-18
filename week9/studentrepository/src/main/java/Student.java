package main.java;

import lombok.Data;
import main.java.customexceptions.DateOfBirthOutsideBoundaries;
import main.java.customexceptions.StringIsEmptyException;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;

@Data
public class Student {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String gender;
    private String id;

    public Student(String firstName, String lastName, LocalDate dateOfBirth, String gender, String id)
            throws StringIsEmptyException, DateOfBirthOutsideBoundaries {

        if (firstName.isEmpty() || lastName.isEmpty()) {
            throw new StringIsEmptyException("Name value cannot be empty!");
        }

        int minYear = LocalDate.now().minusYears(18).getYear();
        if (dateOfBirth.getYear() > 1900 && dateOfBirth.getYear() < minYear) {
            throw new DateOfBirthOutsideBoundaries("Year of birth " + dateOfBirth.getYear() + " is not between 1900 and " + minYear);
        }

        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.id = id;
    }

    public Map<String, Integer> calculateAge() {
        Map<String, Integer> ageMap = new HashMap<>();

        LocalDate currentDate = LocalDate.now();
        Period age = Period.between(dateOfBirth, currentDate);
        ageMap.put("years", age.getYears());
        ageMap.put("months", age.getMonths());
        ageMap.put("days", age.getDays());
        return ageMap;
    }
}
