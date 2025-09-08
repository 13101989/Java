package main.java;

import lombok.Data;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@Data
public class Student {
    private static final Logger logger = Logger.getLogger(Student.class.getName());

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String gender;
    private String id;

    public Student(String firstName, String lastName, LocalDate dateOfBirth, String gender, String id) {

        if (firstName.isEmpty() || lastName.isEmpty()) {
            String exceptionMessage = "IllegalArgumentException exception thrown: Name value cannot be empty!";
            logger.severe(exceptionMessage);
            throw new IllegalArgumentException(exceptionMessage);
        }

        int minYear = LocalDate.now().minusYears(18).getYear();
        if (dateOfBirth.getYear() < 1900 || dateOfBirth.getYear() > minYear) {
            String exceptionMessage = "IllegalArgumentException exception thrown: " +
                    "Year of birth '" + dateOfBirth.getYear() + "' should be between 1900 and " + minYear + "!";
            logger.severe(exceptionMessage);
            throw new IllegalArgumentException(exceptionMessage);
        }

        if (!(gender.equalsIgnoreCase("male") ||
                gender.equalsIgnoreCase("female") ||
                gender.equalsIgnoreCase("m") ||
                gender.equalsIgnoreCase("f"))) {
            String exceptionMessage = "IllegalArgumentException exception thrown: " +
                    "Gender '" + gender + "' is not a valid value, please choose between 'm', 'male', 'f', and 'female' (case-insensitive)!";
            logger.severe(exceptionMessage);
            throw new IllegalArgumentException(exceptionMessage);
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
